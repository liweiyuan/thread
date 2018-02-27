package xx.yy.concurrent.nio;


import javax.swing.*;
import java.awt.*;

public class ForMyLove {
    JFrame jframe;
    PaintWord paint_word;
    int x = 70;
    int y = 370;

    private void write_wo() {
        for (int a = 0; a < 100; a++) {
            y--;
            x++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (y == 0) {
                break;
            }
        }
        x = 120;
        y = 320;
        for (int a = 0; a < 150; a++) {
            y = y + 2;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        y = 620;
        for (int a = 0; a < 50; a++) {
            x--;
            y--;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 280;
        y = 290;
        for (int a = 0; a < 320; a++) {
            y++;
            if (y % 4 == 0) {
                x++;
            }
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 360;
        y = 610;
        for (int a = 0; a < 80; a++) {
            y--;
            if (y % 4 == 0) {
                x++;
            }
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 70;
        y = 440;
        for (int a = 0; a < 300; a++) {
            x++;
            if (x % 4 == 0) {
                y--;
            }
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 60;
        y = 530;
        for (int a = 0; a < 100; a++) {
            x++;
            if (x % 4 == 0) {
                y--;
            }
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 380;
        y = 450;
        for (int a = 0; a < 90; a++) {
            y++;
            x--;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 350;
        y = 280;
        for (int a = 0; a < 30; a++) {
            x++;
            y++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void write_xi() {
        x = 470;
        y = 320;
        for (int a = 0; a < 180; a++) {
            x++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 560;
        y = 260;
        for (int a = 0; a < 100; a++) {
            y++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 490;
        y = 370;
        for (int a = 0; a < 140; a++) {
            x++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 510;
        y = 410;
        for (int a = 0; a < 100; a++) {
            x++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 610;
        y = 410;
        for (int a = 0; a < 50; a++) {
            y++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 600;
        y = 460;
        for (int a = 0; a < 90; a++) {
            x--;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 510;
        y = 410;
        for (int a = 0; a < 50; a++) {
            y++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 510;
        y = 490;
        for (int a = 0; a < 30; a++) {
            y++;
            if (y % 6 == 0) {
                x++;
            }
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 610;
        y = 490;
        for (int a = 0; a < 30; a++) {
            y++;
            if (y % 6 == 0) {
                x--;
            }
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 440;
        y = 520;
        for (int a = 0; a < 250; a++) {
            x++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 510;
        y = 560;
        for (int a = 0; a < 100; a++) {
            x++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 610;
        y = 560;
        for (int a = 0; a < 50; a++) {
            y++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 600;
        y = 610;
        for (int a = 0; a < 90; a++) {
            x--;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 510;
        y = 610;
        for (int a = 0; a < 50; a++) {
            y--;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void write_huan() {
        x = 720;
        y = 400;
        for (int a = 0; a < 50; a++) {
            x++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 770;
        for (int a = 0; a < 140; a++) {
            y++;
            if (y % 3 == 0) {
                x--;
            }
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 720;
        y = 400;
        for (int a = 0; a < 140; a++) {
            y++;
            if (y % 3 == 0) {
                x++;
            }
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 840;
        y = 340;
        for (int a = 0; a < 70; a++) {
            y++;
            if (y % 2 == 0) {
                x--;
            }
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 820;
        y = 380;
        for (int a = 0; a < 120; a++) {
            x++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 940;
        y = 380;
        for (int a = 0; a < 30; a++) {
            y++;
            if (y % 2 == 0) {
                x--;
            }
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 870;
        y = 420;
        for (int a = 0; a < 120; a++) {
            y++;
            if (y % 3 == 0) {
                x--;
            }
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 870;
        y = 460;
        for (int a = 0; a < 80; a++) {
            y++;
            if (y % 2 == 0) {
                x++;
            }
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void write_ni() {
        x = 990;
        y = 370;
        for (int a = 0; a < 70; a++) {
            y--;
            x++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 1040;
        y = 330;
        for (int a = 0; a < 220; a++) {
            y++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 1100;
        y = 350;
        for (int a = 0; a < 70; a++) {
            y--;
            if (y % 2 == 0) {
                x++;
            }
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 1120;
        y = 330;
        for (int a = 0; a < 140; a++) {
            x++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 1260;
        y = 330;
        for (int a = 0; a < 40; a++) {
            y++;
            if (y % 2 == 0) {
                x--;
            }
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 1170;
        y = 380;
        for (int a = 0; a < 180; a++) {
            y++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 1170;
        y = 560;
        for (int a = 0; a < 40; a++) {
            y--;
            if (y % 2 == 0) {
                x--;
            }
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 1130;
        y = 440;
        for (int a = 0; a < 40; a++) {
            y++;
            x--;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        x = 1210;
        y = 440;
        for (int a = 0; a < 40; a++) {
            y++;
            x++;
            paint_word.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void go() {
        jframe = new JFrame();
        paint_word = new PaintWord();
        jframe.getContentPane().add(BorderLayout.CENTER, paint_word);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(1366, 730);
        jframe.setVisible(true);
        write_wo();
        write_xi();
        write_huan();
        write_ni();
    }

    class PaintWord extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.green);
            g.fillOval(x, y, 20, 20);
        }
    }

    public static void main(String[] args) {
        ForMyLove start = new ForMyLove();
        start.go();
    }
}
