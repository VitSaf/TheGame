package relex.game;
    import relex.characters.Character;
public class Game {
    private int move;
    private final static int COUNT_OF_LVLS = 20;
    private Character[] players = new Character[2];


        public Game(Character player1, Character player2){
            move = 0;
            if (Math.random() < 0.5){
                players[0] = player2;
                players[1] = player1;
            }else{
                players[0] = player1;
                players[1] = player2;
            }
        }

        public void move(){
            for (Character c : players){
                if (c.isAbleToMove()){
                    //TODO варианты хода


                    //в конце хода проверка на победу
                    if (c.getFloor() == COUNT_OF_LVLS) System.out.println(c.getName() + " is winner!!!!!!");
                    //TODO закончить игру
                }else {//Этот вариант только в случае блока гномом
                    System.out.println("You miss this turn");
                    c.setAbleToMove(true);
                }
            }
        }

}
