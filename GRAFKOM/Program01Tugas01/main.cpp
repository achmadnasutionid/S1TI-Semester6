/*
    PRAKTIKUM 2
    11S16032
    ACHMAD YUSUF NASUTION
*/

#include <windows.h>
#include <GL/glut.h>

int p1[] = {60, 100};
int p2[] = {70, 100};
int p3[] = {120, 100};
int p4[] = {130, 100};
int p5[] = {60, 90};
int p6[] = {70, 90};
int p7[] = {120, 90};
int p8[] = {130, 90};
int p9[] = {70, 50};
int p10[] = {120, 50};

void init(void) {
    glClearColor(1.0, 1.0, 1.0, 0.0);
    glMatrixMode(GL_PROJECTION);
    gluOrtho2D(0.0, 200.0, 0.0, 150.0);
}

void lineSegment(void) {
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(0.0, 0.4, 0.2);
    glBegin(GL_LINES);
        glVertex2iv(p1);
        glVertex2iv(p2);
        glVertex2iv(p3);
        glVertex2iv(p4);
        glVertex2iv(p5);
        glVertex2iv(p6);
        glVertex2iv(p7);
        glVertex2iv(p8);
        glVertex2iv(p9);
        glVertex2iv(p10);
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
