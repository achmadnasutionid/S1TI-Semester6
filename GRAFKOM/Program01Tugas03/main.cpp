/*
    PRAKTIKUM 2
    11S16032
    ACHMAD YUSUF NASUTION
*/

#include <windows.h>
#include <GL/glut.h>

void init(void) {
    glClearColor(1.0, 1.0, 1.0, 0.0);
    glMatrixMode(GL_PROJECTION);
    gluOrtho2D(0.0, 200.0, 0.0, 150.0);
}

void lineSegment(void) {
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(0.0, 0.4, 0.2);
    glBegin(GL_POLYGON);
        glVertex3f(25, 25, 0);
        glVertex3f(75, 25, 0);
        glVertex3f(75, 75, 0);
        glVertex3f(25, 75, 0);
    glEnd();
    glBegin(GL_POLYGON);
        glVertex3f(50, 50, 0);
        glVertex3f(100, 50, 0);
        glVertex3f(100, 100, 0);
        glVertex3f(50, 100, 0);
    glEnd();
    glBegin(GL_POLYGON);
        glVertex3f(75, 75, 0);
        glVertex3f(125, 75, 0);
        glVertex3f(125, 125, 0);
        glVertex3f(75, 125, 0);
    glEnd();
    glBegin(GL_POLYGON);
        glVertex3f(100, 50, 0);
        glVertex3f(150, 50, 0);
        glVertex3f(150, 100, 0);
        glVertex3f(100, 100, 0);
    glEnd();
    glBegin(GL_POLYGON);
        glVertex3f(125, 25, 0);
        glVertex3f(175, 25, 0);
        glVertex3f(175, 75, 0);
        glVertex3f(125, 75, 0);
    glEnd();
    glFlush();
}

int main(int argc, char** argv) {
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
    glutInitWindowPosition(550, 200);
    glutInitWindowSize(400, 300);
    glutCreateWindow("OpenGL Practicum 02 Program 01");
    init();
    glutDisplayFunc(lineSegment);
    glutMainLoop();
    return 0;
}
