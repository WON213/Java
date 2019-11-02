 import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
//10217 �̽���
public class Bingo extends Frame implements ActionListener {
 
 String numstr[] = { "����", "�η��", "Ȳ��", "��ѱ�", "�����", "����", "Ÿ��", "�ξ���", "�û���", "���", "��", "��", "������", "�ײ�", "��",
  
   "����", "������", "�ܵ�", "��Ȳ", "����", "��ġ", "���", "�޹���", "�Ҳ���", "���" };
 // String numstr[] �迭�ȿ� 25������ �������� �̸��� �ִ´�.
 Button ai[] = new Button[25];
 
 Random random = new Random();
 // Button�� Ŭ������ ai�� �������ְ� �迭�ȿ� 25���� ��ư�� �� ��ŭ �ִ´�.
 
 public Bingo() { // Bingo�� �����ڸ� ������ش�.
  init(); // ���� �ʱ�ȭ
  setTitle("���� ����"); // ���α׷� ����
  setSize(450, 450); // ���α׷� ũ�� (����, ����)
  setVisible(true); // ���α׷� ȭ�鿡 ����
  setLayout(new GridLayout(5, 5)); // ��ư�� 5, 5 ������ ���� �׸��� ���̾ƿ� ���
 
  addWindowListener(new WindowAdapter() {
   @Override
   public void windowClosing(WindowEvent e) { // ���α׷� ���Ḧ ���� �̺�Ʈ
    System.exit(0); // ����
   }
  });
 
  for (int i = 0; i < ai.length; i++) {
   ai[i].addActionListener(this); // ��ư Ŭ���� �����ϴ� �̺�Ʈ Ŭ���� 
  }
 
  for (int i = 0; i < 25; i++) { // ��ư 25���� �ݺ����� ����ؼ� �����ش�.
   add(ai[i]); // ��ư�� �߰��� �� ��ư 25���� �迭�� �ݺ����� ����� ����ش�. 
  }
 
 }
 
 private void init() {
 
  int test[] = new int[25]; // test �迭�ȿ� 25���� �ִ´�. 
  for (int i = 0; i < 25; i++) { // i�� 25���� ������ 
   test[i] = random.nextInt(numstr.length); // test �迭�ȿ� ��� �� ���� i�� ��Ʈ������ ��ȯ ���ֱ� ���ؼ� �ڿ� (numstr.length) �ִ´�.
   for (int j = 0; j < i; j++) { // j�� i���� ������ 
    if (test[i] == test[j]) { // �ߺ����Ÿ� �ϱ� ���ؼ� i �� j �� ���ؼ� ���� ���� ������ �� �� 
     i--; // i���� 1�� ���ش�. 
    }
 
    for (int j2 = 0; j2 < 25; j2++) { 
     ai[j2] = new Button(numstr[test[j2]]); 
     // ��ư�� 25�� �̸����� �������� ����ϱ� ���ؼ� (����̸� ���(��ư�� ���� 25���� ��Ʈ�� �迭(��ư�� �� ��ŭ ������.)
    }
   }
  }
 }
 
 public static void main(String[] args) {
  new Bingo(); // â�� �����ϱ� ���ؼ� ���� �޼ҵ带 ����
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {
 
  for (int i = 0; i < ai.length; i++) {
   if (e.getSource() == ai[i]) {
    ai[i].setBackground(Color.LIGHT_GRAY); // ��ư�� �������� ��ư�� ������ ����ȸ������ ����.
   }
  }
 }
} 