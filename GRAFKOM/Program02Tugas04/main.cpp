#include <windows.h>
#include <stdlib.h>
#include <math.h>
#include <GL/glut.h>
#include <stdio.h>
#include <string.h>
#include <stdarg.h>

void init(void) {
    glClearColor(1.0, 1.0, 1.0, 0.0);
    glMatrixMode(GL_PROJECTION);
    gluOrtho2D(0.0, 200.0, 0.0, 150.0);
}

class screenPt {
private:
    GLint x;
    GLint y;

public:
    screenPt() {
        x = 0;
        y = 0;
    }

    void setCoords(GLint xCoordValue, GLint yCoordValue) {
        x = xCoordValue;
        y = yCoordValue;
    }

    GLint getx() const {
        return x;
    }

    GLint gety() const {
        return y;
    }

    void incrementx() {
        x++;
    }

    void decrementy() {
        y--;
    }
};

void setPixel(int x, int y) {
    glBegin(GL_POINTS);
        glVertex2i(x, y);
    glEnd();
    glFlush();
}

void circleMidpoint(GLint xc, GLint yc, GLint radius) {
    screenPt circPt;

    GLint p = 1 - radius;

    circPt.setCoords(0, radius);

    void circlePlotPoints(GLint, GLint, screenPt);
    circlePlotPoints(xc, yc, circPt);
    while(circPt.getx() < circPt.gety()) {
        circPt.incrementx();
        if(p < 0) {
            p += 2 * circPt.getx() + 1;
        }
        else {
            circPt.decrementy();
            p += 2 * (circPt.getx() - circPt.gety()) + 1;
        }
        circlePlotPoints(xc, yc, circPt);
    }
}

void circlePlotPoints(GLint xc, GLint yc, screenPt circPt) {
    setPixel(xc + circPt.getx(), yc + circPt.gety());
    setPixel(xc - circPt.getx(), yc + circPt.gety());
    setPixel(xc + circPt.getx(), yc - circPt.gety());
    setPixel(xc - circPt.getx(), yc - circPt.gety());
    setPixel(xc + circPt.getx(), yc + circPt.gety());
    setPixel(xc - circPt.getx(), yc + circPt.gety());
    setPixel(xc + circPt.getx(), yc - circPt.gety());
    setPixel(xc - circPt.getx(), yc - circPt.gety());
}

void lineDDA(int x0, int y0, int xEnd, int yEnd) {
    int dx = xEnd - x0;
    int dy = yEnd - y0;
    int steps;
    int k;
    int xIncrement;
    int yIncrement;
    int x = x0;
    int y = y0;

    if(fabs(dx) > fabs(dy)) {
        steps = fabs(dx);
    }
    else {
        steps = fabs(dy);
    }
    xIncrement = dx / steps;
    yIncrement = dy / steps;

    setPixel(x, y);
    for(k = 0; k < steps; k++) {
        x += xIncrement;
        y += yIncrement;
        setPixel(x, y);
    }
}

void lineBres(int x0, int y0, int xEnd, int yEnd) {
    int dx = fabs(xEnd - x0);
    int dy = fabs(yEnd - y0);
    int p = 2 * dy - dx;
    int twoDy = 2 * dy;
    int twoDyMinusDx = 2 * (dy - dx);
    int x;
    int y;

    if(x0 > xEnd) {
        x = xEnd;
        y = yEnd;
        xEnd = x0;
    }
    else {
        x = x0;
        y = y0;
    }
    setPixel(x, y);

    while(x < xEnd) {
        x++;
        if(p < 0) {
            p += twoDy;
        }
        else {
           y++;
           p += twoDyMinusDx;
        }
        setPixel(x, y);
    }
}

void display() {
    lineDDA(50, 100, 150, 100);
    lineDDA(50, 50, 150, 50);
    lineDDA(50, 100, 50, 50);
    lineDDA(150, 100, 150, 50);
    lineDDA(75, 100, 75, 125);
    lineDDA(125, 100, 125, 125);
    circleMidpoint(75, 125, 10);
    circleMidpoint(125, 125, 10);
    circleMidpoint(75, 80, 15);
    circleMidpoint(125, 80, 15);
    lineDDA(75, 55, 125, 55);
    lineDDA(70, 0, 70, 40);
    lineDDA(130, 0, 130, 40);
    lineDDA(70, 40, 130, 40);
    lineDDA(95, 40, 95, 50);
    lineDDA(105, 40, 105, 50);
    lineBres(80, 0, 90, 40);
    lineBres(85, 0, 90, 40);
    lineBres(90, 0, 90, 40);
}

int main(int argc, char** argv) {
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
    glutInitWindowPosition(550, 200);
    glutInitWindowSize(400, 300);
    glutCreateWindow("OpenGL Practicum 03 Program 02");
    init();
    glutDisplayFunc(display);
    glutMainLoop();
    return 0;
}
