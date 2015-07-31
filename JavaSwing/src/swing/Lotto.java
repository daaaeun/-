package swing;

import java.util.Arrays;

public class Lotto {
	// 로또는 1 ~ 45 까지 중복되지 않는
	// 랜덤 숫자들의 집합
	/* 필드 */
	int[] lotto = new int[6];
	/* 생성자 */
	/* 멤버메소드 */
	
	
	public int[] getLotto() {
		return lotto;
	}
	// 로또는 외부에서 숫자를 주입받는 것이 아니라
	// 자체적으로 랜덤숫자를 발생시켜야한다.
	// 통장 계좌번호와 흡사
	public void setLotto() {
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = 0; // 배열 내부의 지역변수 6개를 for문을 이용해서 0으로 초기화하는 로직 
		}
		for (int i = 0; i < lotto.length; i++) {
			//로또의 사이즈 6만큼 회전하면서 랜덤숫자 6개를 생성
			int randomNum = (int) ((Math.random()*45)+1);
			//로또의 법칙 : 로또는 숫자가 중복이 있어서는 안된다.
			//나중에 나온 숫자가 먼저 나온 숫자와 같다면
			//그 숫자는 폐기하고 다시 돌아야한다.
			//이 때, 카운트 숫자는 증가하면 안된다.
			boolean exist = false;
			// for문 내부에 다시 for문을 주어(이중for문)
			// 번호의 중복여부를 체그하고 만약 중복되었다면
			// 회전 카운트(i) 값을 마이너스 처리하여
			// 이번 회전을 무효화시킨다.
			for (int j = 0; j < lotto.length; j++) {
				if (randomNum == lotto[j]) {
					exist = true;
					break;
				}
			}
			if (exist) {
				i--;
				continue;
			}else {
				lotto[i] = randomNum;
			}
		}
		// 중복이 되지 않은 6개의 랜덤숫자가 배열에 담겼다면
		// 그 배열의 숫자를 오름차순으로 정렬해야 함
		Arrays.sort(lotto);
	}
	
}
