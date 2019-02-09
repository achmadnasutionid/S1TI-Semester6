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
    glBegin(GL_TRIANGLES);
        glVertex2f(10, 10);
        glColor3f(0, 1, 0);
        glVertex2f(100, 100);
        glColor3f(1, 0, 0);
        glVertex2f(190, 10);
        glColor3f(0, 0, 1);
        glVertex2f(80, 70);
        glColor3f(0, 0, 1);
        glVertex2f(100, 90);
        glColor3f(1, 0, 0);
        glVertex2f(120, 70);
        glColor3f(0, 1, 0);
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
