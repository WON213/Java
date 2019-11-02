 import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
//10217 이승현
public class Bingo extends Frame implements ActionListener {
 
 String numstr[] = { "참새", "두루미", "황새", "비둘기", "까오기", "오리", "타조", "부엉이", "올빼미", "뱁새", "꿩", "닭", "구관조", "잉꼬", "매",
  
   "거위", "독수리", "콘돌", "봉황", "공작", "까치", "까마귀", "앵무새", "꾀꼬리", "고니" };
 // String numstr[] 배열안에 25가지의 동물들의 이름을 넣는다.
 Button ai[] = new Button[25];
 
 Random random = new Random();
 // Button의 클래스를 ai로 지정해주고 배열안에 25개의 버튼를 수 만큼 넣는다.
 
 public Bingo() { // Bingo의 생성자를 만들어준다.
  init(); // 변수 초기화
  setTitle("빙고 게임"); // 프로그램 제목
  setSize(450, 450); // 프로그램 크기 (가로, 세로)
  setVisible(true); // 프로그램 화면에 띄우기
  setLayout(new GridLayout(5, 5)); // 버튼의 5, 5 평행을 위해 그리드 레이아웃 사용
 
  addWindowListener(new WindowAdapter() {
   @Override
   public void windowClosing(WindowEvent e) { // 프로그램 종료를 위한 이벤트
    System.exit(0); // 종료
   }
  });
 
  for (int i = 0; i < ai.length; i++) {
   ai[i].addActionListener(this); // 버튼 클릭시 동작하는 이벤트 클래스 
  }
 
  for (int i = 0; i < 25; i++) { // 버튼 25개를 반복문을 사용해서 돌려준다.
   add(ai[i]); // 버튼을 추가할 때 버튼 25개를 배열로 반복문을 사용해 띄어준다. 
  }
 
 }
 
 private void init() {
 
  int test[] = new int[25]; // test 배열안에 25개를 넣는다. 
  for (int i = 0; i < 25; i++) { // i가 25보다 작으면 
   test[i] = random.nextInt(numstr.length); // test 배열안에 들어 갈 랜덤 i를 스트링으로 변환 해주기 위해서 뒤에 (numstr.length) 넣는다.
   for (int j = 0; j < i; j++) { // j가 i보다 작으면 
    if (test[i] == test[j]) { // 중복제거를 하기 위해서 i 와 j 를 비교해서 같은 것이 나오게 될 시 
     i--; // i에서 1를 빼준다. 
    }
 
    for (int j2 = 0; j2 < 25; j2++) { 
     ai[j2] = new Button(numstr[test[j2]]); 
     // 버튼에 25개 이름들을 랜덤으로 출력하기 위해서 (출력이름 목록(버튼에 들어가는 25개의 스트링 배열(버튼의 수 만큼 돌린다.)
    }
   }
  }
 }
 
 public static void main(String[] args) {
  new Bingo(); // 창을 실행하기 위해서 메인 메소드를 생성
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {
 
  for (int i = 0; i < ai.length; i++) {
   if (e.getSource() == ai[i]) {
    ai[i].setBackground(Color.LIGHT_GRAY); // 버튼을 눌렀을때 버튼의 배경색을 밝은회색으로 변경.
   }
  }
 }
} 