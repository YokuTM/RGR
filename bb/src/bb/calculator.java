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
JButton buttonResult = new JButton("Результат");

public calculator() {
buttonResult.setEnabled(false);
add(buttonResult, BorderLayout.NORTH); //Добавляем кнопку суммы и указываем ее расположение
JPanel radioPanel = new JPanel(new GridLayout(5, 1)); // Определяем расположение элементов
radioPanel.setBackground(Color.lightGray); //Устанавливаем цвет панелей
radioPanel.setLayout((LayoutManager) new BoxLayout(radioPanel, BoxLayout.Y_AXIS)); // Указываем расположение строк
setBounds(250, 250, 250, 250); //Определяем размер окна
add(radioPanel, BorderLayout.CENTER);// Указываем расположение строк
final JTextField otrabdni = new JTextField(); //Объявляем поля ввода
final JTextField rabdni = new JTextField(); //Объявляем поля ввода
final JTextField oklad = new JTextField(); //Объявляем поля ввода
final JTextField prem = new JTextField(); //Объявляем поля ввода

JLabel otrabdnitext = new JLabel("отработанные дни:"); // Задаем название строк
JLabel rabdnitext = new JLabel("рабочие дни:"); // Задаем название строк
JLabel okladtext = new JLabel("оклад"); // Задаем название строк
JLabel premtext = new JLabel("премия"); // Задаем название строк

//Добавляем текстовые строки и поля для ввода
radioPanel.add(otrabdnitext);
radioPanel.add(otrabdni);
radioPanel.add(rabdnitext);
radioPanel.add(rabdni);
radioPanel.add(okladtext);
radioPanel.add(oklad);
radioPanel.add(premtext);
radioPanel.add(prem);

otrabdni.addKeyListener(new KeyAdapter() { //Добавляем слушателя на поле для ввода
public void keyTyped(KeyEvent e) {
char c = e.getKeyChar();
if ( ((c < '0') || (c > '9'))) {
e.consume(); // Игнорим введенные буквы и пробел
}
if (otrabdni.getText().length() >= 2){
JOptionPane.showMessageDialog(null, "Максимальное кол-во символов 2", "Неправильный ввод",JOptionPane.WARNING_MESSAGE );
} //Не даем пользователю вводить больше 2 символов в строку
}
});
rabdni.addKeyListener(new KeyAdapter() {
public void keyTyped(KeyEvent e) {
char c = e.getKeyChar();
if ( ((c < '0') || (c > '9'))) {
e.consume(); // Игнорируем введенные буквы и пробел
}
if (rabdni.getText().length() >= 2){
JOptionPane.showMessageDialog(null, "Максимальное кол-во символов 2", "Неправильный ввод",JOptionPane.WARNING_MESSAGE );
} //Не даем пользователю вводить больше 2 символов в строку
}
});
oklad.addKeyListener(new KeyAdapter() {
public void keyTyped(KeyEvent e) {
char c = e.getKeyChar();
if ( ((c < '0') || (c > '9'))) {
e.consume(); // Игнорируем введенные буквы и пробел
}

}
});
prem.addKeyListener(new KeyAdapter() {
public void keyTyped(KeyEvent e) {
char c = e.getKeyChar();
if ( ((c < '0') || (c > '9'))) {
e.consume(); // Игнорируем введенные буквы и пробел
}

}
});

JButton calculate = new JButton("РАСЧЕТ");
calculate.setBackground(new Color(255, 228, 225)); //Задаем цвет кнопки
calculate.addActionListener(new ActionListener() { //Добавляем слушателя на кнопку
public void actionPerformed(ActionEvent e) {
Float s = Float.parseFloat((oklad.getText())); //Преобразовываем введенные в поле значения в тип данных float
Float t = Float.parseFloat((rabdni.getText())); //Преобразовываем введенные в поле значения в тип данных float
Float m = Float.parseFloat((otrabdni.getText())); //Преобразовываем введенные в поле значения в тип данных float
Float p = Float.parseFloat((prem.getText())); //Преобразовываем введенные в поле
float result= Result(s,t,m,p); //Передаем данные в метод для вычисления
buttonResult.setText(Float.toString(result));
}
});

buttonResult.setBackground(new Color(255, 248, 220)); //Устанавливаем цвет панели
radioPanel.add(calculate);
setVisible(true); //Делаем окно видимым
}

public float Result(float oklad,float rabdni,float otrabdni, float prem) { //Задаем переменные и метод
float result = ((oklad*otrabdni)/rabdni)+prem; //Формула подсчета
return result; //Возвращаем значение
}

public static void main(String[] args) {
new calculator();
}

//Переводим в формат вида string
private static String format (int i) {
String result = String.valueOf(i);
if (result.length() == 1) {
result = "0" + result;
}
return result; //Возвращаем значение
}

}