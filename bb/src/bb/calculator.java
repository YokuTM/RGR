package bb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculator extends JFrame {
/**
*
*/
private static final long serialVersionUID = 1L;
float result;
JButton buttonResult = new JButton("���������");

public calculator() {
buttonResult.setEnabled(false);
add(buttonResult, BorderLayout.NORTH); //��������� ������ ����� � ��������� �� ������������
JPanel radioPanel = new JPanel(new GridLayout(5, 1)); // ���������� ������������ ���������
radioPanel.setBackground(Color.lightGray); //������������� ���� �������
radioPanel.setLayout((LayoutManager) new BoxLayout(radioPanel, BoxLayout.Y_AXIS)); // ��������� ������������ �����
setBounds(250, 250, 250, 250); //���������� ������ ����
add(radioPanel, BorderLayout.CENTER);// ��������� ������������ �����
final JTextField otrabdni = new JTextField(); //��������� ���� �����
final JTextField rabdni = new JTextField(); //��������� ���� �����
final JTextField oklad = new JTextField(); //��������� ���� �����
final JTextField prem = new JTextField(); //��������� ���� �����

JLabel otrabdnitext = new JLabel("������������ ���:"); // ������ �������� �����
JLabel rabdnitext = new JLabel("������� ���:"); // ������ �������� �����
JLabel okladtext = new JLabel("�����"); // ������ �������� �����
JLabel premtext = new JLabel("������"); // ������ �������� �����

//��������� ��������� ������ � ���� ��� �����
radioPanel.add(otrabdnitext);
radioPanel.add(otrabdni);
radioPanel.add(rabdnitext);
radioPanel.add(rabdni);
radioPanel.add(okladtext);
radioPanel.add(oklad);
radioPanel.add(premtext);
radioPanel.add(prem);

otrabdni.addKeyListener(new KeyAdapter() { //��������� ��������� �� ���� ��� �����
public void keyTyped(KeyEvent e) {
char c = e.getKeyChar();
if ( ((c < '0') || (c > '9'))) {
e.consume(); // ������� ��������� ����� � ������
}
if (otrabdni.getText().length() >= 2){
JOptionPane.showMessageDialog(null, "������������ ���-�� �������� 2", "������������ ����",JOptionPane.WARNING_MESSAGE );
} //�� ���� ������������ ������� ������ 2 �������� � ������
}
});
rabdni.addKeyListener(new KeyAdapter() {
public void keyTyped(KeyEvent e) {
char c = e.getKeyChar();
if ( ((c < '0') || (c > '9'))) {
e.consume(); // ���������� ��������� ����� � ������
}
if (rabdni.getText().length() >= 2){
JOptionPane.showMessageDialog(null, "������������ ���-�� �������� 2", "������������ ����",JOptionPane.WARNING_MESSAGE );
} //�� ���� ������������ ������� ������ 2 �������� � ������
}
});
oklad.addKeyListener(new KeyAdapter() {
public void keyTyped(KeyEvent e) {
char c = e.getKeyChar();
if ( ((c < '0') || (c > '9'))) {
e.consume(); // ���������� ��������� ����� � ������
}

}
});
prem.addKeyListener(new KeyAdapter() {
public void keyTyped(KeyEvent e) {
char c = e.getKeyChar();
if ( ((c < '0') || (c > '9'))) {
e.consume(); // ���������� ��������� ����� � ������
}

}
});

JButton calculate = new JButton("������");
calculate.setBackground(new Color(255, 228, 225)); //������ ���� ������
calculate.addActionListener(new ActionListener() { //��������� ��������� �� ������
public void actionPerformed(ActionEvent e) {
Float s = Float.parseFloat((oklad.getText())); //��������������� ��������� � ���� �������� � ��� ������ float
Float t = Float.parseFloat((rabdni.getText())); //��������������� ��������� � ���� �������� � ��� ������ float
Float m = Float.parseFloat((otrabdni.getText())); //��������������� ��������� � ���� �������� � ��� ������ float
Float p = Float.parseFloat((prem.getText())); //��������������� ��������� � ����
float result= Result(s,t,m,p); //�������� ������ � ����� ��� ����������
buttonResult.setText(Float.toString(result));
}
});

buttonResult.setBackground(new Color(255, 248, 220)); //������������� ���� ������
radioPanel.add(calculate);
setVisible(true); //������ ���� �������
}

public float Result(float oklad,float rabdni,float otrabdni, float prem) { //������ ���������� � �����
float result = ((oklad*otrabdni)/rabdni)+prem; //������� ��������
return result; //���������� ��������
}

public static void main(String[] args) {
new calculator();
}

//��������� � ������ ���� string
private static String format (int i) {
String result = String.valueOf(i);
if (result.length() == 1) {
result = "0" + result;
}
return result; //���������� ��������
}

}