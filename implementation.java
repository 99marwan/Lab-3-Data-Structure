package eg.edu.alexu.csd.datastructure.iceHockey;

import java.awt.Point;
import java.util.Arrays;

public class implementation implements IPlayerFinder {

  public int x_min = 100, x_max = 0, y_min = 100, y_max = 0;
  public int numOfBoxes(int i, int j,int team,char[][] photo )
  {
    int count = 0;
    char change = Character.forDigit(team, 10);
    if ((photo[i][j] != change)) {
      return 0;
    }
    else if (photo[i][j] == change) {
      if (j < x_min) {
        x_min = j;
      }
      
      if (j > x_max) {
        x_max = j;
        //System.out.println("xmax="+x_max);
      }
      if (i < y_min) {
        y_min = i;
        //System.out.println("ymin="+y_min);
      }
      if (i > y_max) {
        y_max = i;
        //System.out.println("ymax="+y_max);
      }
      count++;
      photo[i][j] = '$';
      if (i == 0 && j == 0) {
        count += numOfBoxes(i, j+1, team, photo);
        count += numOfBoxes(i+1, j, team, photo);
      }
      if (i == 0 && j != 0 && j != photo[0].length-1) {
        count+=numOfBoxes(i,j+1,team,photo);
        count+=numOfBoxes(i+1,j,team,photo);
        count+=numOfBoxes(i,j-1,team,photo);
      }
           if(i==0 && j==photo[0].length-1)
           {
              count+=numOfBoxes(i+1,j,team,photo);
              count+=numOfBoxes(i,j-1,team,photo);
           }
           if(i!=0 && i!=photo.length-1 && j==0)
           {
                count+=numOfBoxes(i-1,j,team,photo);
                count+=numOfBoxes(i,j+1,team,photo);
                count+=numOfBoxes(i+1,j,team,photo);
            }
            if(i==photo.length-1 && j==0)
            {
                count+=numOfBoxes(i-1,j,team,photo);
                count+=numOfBoxes(i,j+1,team,photo);
            }
            if(i==photo.length-1 && j!=0 && j!=photo[0].length-1)
            {
                count+=numOfBoxes(i-1,j,team,photo);
                count+=numOfBoxes(i,j+1,team,photo);
                count+=numOfBoxes(i,j-1,team,photo);

            }
            if(i==photo.length-1 && j==photo[0].length-1)
            {
                count+=numOfBoxes(i-1,j,team,photo);
                count+=numOfBoxes(i,j-1,team,photo);
            }
            if(i!=photo.length-1 && i!=0 && j==photo[0].length-1)
            {
                count+=numOfBoxes(i-1,j,team,photo);
                count+=numOfBoxes(i,j-1,team,photo);
                count+=numOfBoxes(i+1,j,team,photo);
            }
            if(i!=photo.length-1 && i!=0 &&j!=0 && j!=photo[0].length-1 )
            {
                count+=numOfBoxes(i-1,j,team,photo);
                count+=numOfBoxes(i,j-1,team,photo);
                count+=numOfBoxes(i+1,j,team,photo);
                count+=numOfBoxes(i,j+1,team,photo);
            }

        }

        return count;
    }

    public Point centre()
    {
        int x=x_min+x_max+1;
        int y=y_min+y_max+1;
        x_min=100;
        x_max=0;
        y_min=100;
        y_max=0;
        Point W= new Point(x,y);

        return W;
    }

    @Override
    public Point[] findPlayers(String[] photo, int team, int threshold)
    {
        Point[] A=new Point[10000];
        Point[] B;
        int counter=0;

        if(photo.length==0)
        {
            return null;
        }
        else
        {
            char[][] ch = new char[photo.length][photo[0].length()];

            implementation test=new implementation();

            for(int i=0; i<photo.length; i++)
            {
                ch[i]=photo[i].toCharArray();
            }


            for(int i=0; i<photo.length; i++)
            {
                for(int j=0; j<photo[0].length(); j++)
                {
                    int x=test.numOfBoxes(i, j, team, ch);
                    if((x*4)>=threshold)
                    {
                        A[counter]=test.centre();
                        counter++;
                    }
                    else
                    {
                        test.x_min=100;
                        test.x_max=0;
                        test.y_min=100;
                        test.y_max=0;
                    }
                }
            }
            if(counter==0)
            {
                return null;
            }
            B=new Point[counter];
            for(int k=0; k<counter; k++)
            {
                B[k]=A[k];

            }
            int testing=1;
            while(testing==1)
            {
                testing=0;
                for(int k=0; k<counter-1; k++)
                {
                    if(B[k].x>B[k+1].x)
                    {
                        Point temp=B[k];
                        B[k]=B[k+1];
                        B[k+1]=temp;
                        testing =1;
                    }
                    else if(B[k].x==B[k+1].x)
                    {
                        if(B[k].y>B[k+1].y)
                        {
                            Point temp=B[k];
                            B[k]=B[k+1];
                            B[k+1]=temp;
                            testing =1;
                        }
                    }
                }
            }

        }
        //System.out.println(Arrays.toString(B));

        return B;
    }


}
