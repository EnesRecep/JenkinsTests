import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PopularVote {

    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);

        int numberOfVoting;
        int numOfVote;

        ArrayList voteArray = new ArrayList();
        float max;
        float sum;
        int winner;
        boolean flag;
        numberOfVoting = input.nextInt();
        while(numberOfVoting > 500 || numberOfVoting < 0){
            System.out.println("tekrar gir number of voting " );
            numberOfVoting = input.nextInt();
        }

        for(int i = 0 ; i < numberOfVoting ; i++){
            max = -999;
            sum = 0;
            winner = -9;
            flag = true;
            do {
                voteArray.clear();

                numOfVote = input.nextInt();

                while (numOfVote < 2 || numOfVote > 10) {
                    System.out.println("tekrar num of vote");
                    numOfVote = input.nextInt();
                }

                for (int j = 0; j < numOfVote; j++) {
                        voteArray.add(input.nextInt());
                        while ((int) voteArray.get(j) < 0 || (int) voteArray.get(j) > 50000) {
                            System.out.println("sayıyı tekrar gir  " + j);
                            voteArray.set(j, input.nextInt());
                        }

                        sum += (int) voteArray.get(j);
                        if ((int) voteArray.get(j) > max) {
                            max = (int) voteArray.get(j);
                            winner = j;

                        }


                    }


            }
            while(sum == 0 );

            ArrayList a2 = (ArrayList) voteArray.clone();
            Collections.sort(a2);
            for(int k = 0 ; k < numOfVote-1 ; k++){
                if((int)voteArray.get(k) != (int)voteArray.get(k+1)){
                    flag = false;
                }
                else if(a2.get(numOfVote-1) == a2.get(numOfVote-2)){
                    flag = false;
                }
            }

            if(flag){
                System.out.println("no winner");
            }
            else {

                if (sum / max < 2.00) {
                    System.out.println("majority winner " + (winner+1));
                } else if (sum / max >= 2.00) {
                    System.out.println("minority winner " + (winner+1));
                }
            }





        }
    }
}
