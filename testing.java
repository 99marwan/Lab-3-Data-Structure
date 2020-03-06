package eg.edu.alexu.csd.datastructure.iceHockey;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.awt.Point;
class testing
{

    @Test
    void test()
    {
        implementation t=new implementation();
        String [] photo = {"11111",
                           "1AAA1",
                           "1A1A1",
                           "1AAA1",
                           "11111"
                          };
        Point[] expected=new Point[2];
        expected[0]=new Point(5,5);
        expected[1]=new Point(5,5);
        Point[] actual=t.findPlayers(photo, 1, 3);

        Assert.assertArrayEquals(expected, actual);

    }
    @Test
    void test2()
    {
        String [] photo = {"8D88888J8L8E888","88NKMG8N8E8JI88","888NS8EU88HN8EO","LUQ888A8TH8OIH8","888QJ88R8SG88TY","88ZQV88B88OUZ8O","FQ88WF8Q8GG88B8","8S888HGSB8FT8S8","8MX88D88888T8K8","8S8A88MGVDG8XK8","M88S8B8I8M88J8N","8W88X88ZT8KA8I8","88SQGB8I8J88W88","U88H8NI8CZB88B8","8PK8H8T8888TQR8"};
        implementation t=new implementation();
        Point[] expected=new Point[19];
        expected[0]=new Point(1,17);
        expected[1]=new Point(3,3);
        expected[2]=new Point(3,10);
        expected[3]=new Point(3,25);
        expected[4]=new Point(5,21);
        expected[5]=new Point(8,17);
        expected[6]=new Point(9,2);
        expected[7]=new Point(10,9);
        expected[8]=new Point(12,23);
        expected[9]=new Point(17,16);
        expected[10]=new Point(18,3);
        expected[11]=new Point(18,11);
        expected[12]=new Point(18,28);
        expected[13]=new Point(22,20);
        expected[14]=new Point(23,26);
        expected[15]=new Point(24,15);
        expected[16]=new Point(27,2);
        expected[17]=new Point(28,26);
        expected[18]=new Point(29,16);
        Point[] actual=t.findPlayers(photo, 8, 9);

        Assert.assertArrayEquals(expected, actual);

    }
    @Test
    void test3()
    {
        String [] photo = {""};
        implementation t=new implementation();

        Point[] actual=t.findPlayers(photo, 1, 3);
        Assert.assertArrayEquals(null, actual);

    }
    @Test
    void test4()
    {
        String [] photo = {"33JUBU33",
                           "3U3O4433",
                           "O33P44NB",
                           "PO3NSDP3",
                           "VNDSD333",
                           "OINFD33X"
                          };
        implementation t=new implementation();
        Point[] expected=new Point[3];
        expected[0]=new Point(4,5);
        expected[1]=new Point(13,9);
        expected[2]=new Point(14,2);
        Point[] actual=t.findPlayers(photo, 3, 16);
        Assert.assertArrayEquals(expected, actual);

    }
    @Test
    void test5()
    {
        String [] photo = {"44444H44S4",
                           "K444K4L444",
                           "4LJ44T44XH",
                           "444O4VIF44",
                           "44C4D4U444",
                           "4V4Y4KB4M4",
                           "G4W4HP4O4W",
                           "4444ZDQ4S4",
                           "4BR4Y4A444",
                           "4G4V4T4444"
                          };
        implementation t=new implementation();
        Point[] expected=new Point[6];
        expected[0]=new Point(3,8);
        expected[1]=new Point(4,16);
        expected[2]=new Point(5,4);
        expected[3]=new Point(16,3);
        expected[4]=new Point(16,17);
        expected[5]=new Point(17,9);
        Point[] actual=t.findPlayers(photo, 4, 16);
        Assert.assertArrayEquals(expected, actual);

    }
    @Test
    void test6()
    {
        String [] photo = {"44444H44S4",
                           "K444K4L444",
                           "4LJ44T44XH",
                           "444O4VIF44",
                           "44C4D4U444",
                           "4V4Y4KB4M4",
                           "G4W4HP4O4W",
                           "4444ZDQ4S4",
                           "4BR4Y4A444",
                           "4G4V4T4444"
                          };
        implementation t=new implementation();
        Point[] actual=t.findPlayers(photo, 3, 16);
        Assert.assertArrayEquals(null, actual);

    }
}
