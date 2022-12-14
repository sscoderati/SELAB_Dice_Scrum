import java.util.*;

public class GameFunc {
    ArrayList<PlayerInfo> pList = new ArrayList<>();
    Scanner s = new Scanner(System.in);
    Random r = new Random();
    public void menuSelect() throws InputMismatchException {
        int selected = 0;
        System.out.println("주사위 게임에 오신 것을 환영합니다. 메뉴를 선택해주세요.");
        System.out.println("1. 게임 시작");
        System.out.println("2. 랭킹 조회");
        System.out.println("3. 게임 종료");
        try {
            selected = s.nextInt();

            while (selected < 1 || selected > 3) {
                System.out.println("입력값이 잘못되었습니다.");
                selected = s.nextInt();
            }
        } catch (InputMismatchException e) {
            System.err.println("입력값이 잘못되었습니다.");
        }

        if (selected == 1) {
            startGame();
        }
        else if (selected == 2) {
            showRank();
        }
        else {
            System.exit(0);
        }
    }
    public void startGame() {
        int diceCount = 0;
        String playerID = null;
        int gameScore = 0;
        int dice1 = 0;
        int dice2 = 0;

        System.out.println("주사위 게임을 시작합니다. ID를 입력해주세요.");
        s.nextLine();
        playerID = s.nextLine();

        while (diceCount < 10) {
            System.out.println(diceCount + 1 + "번째 주사위를 던집니다.");
            dice1 = r.nextInt(6) + 1;
            dice2 = r.nextInt(6) + 1;
            System.out.println("결과 : (" + dice1 + ", " + dice2 + ")");
            if (dice1 + dice2 == 7) {
                System.out.println("점수를 얻었습니다.");
                gameScore++;
            }
            diceCount++;
        }
        System.out.println(playerID + ", 게임의 최종 점수는 " + gameScore + "점 입니다.");
        PlayerInfo p = new PlayerInfo(playerID, gameScore);
        pList.add(p);
        menuSelect();
    }
    public void showRank() {
        Collections.sort(pList);
        if (pList.size() <= 10) {
            for (PlayerInfo p: pList) {
                System.out.println(String.format("ID : %s, Score : %d", p.ID, p.gameScore));
            }
        } else {
            for (int i = 0; i < 10; i++) {
                System.out.println(String.format("ID : %s, Score : %d", pList.get(i).ID, pList.get(i).gameScore));
            }
        }
        menuSelect();
    }
}
