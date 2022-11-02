//Quiz von Kev.


public class quiz { public static void main(String[] args) {

//Ziel vom Quiz = Schreibe das Wort BANANA. Ändere nur da, wo es dir die Kommentare erlauben.

    char a = 65;
    char b = 66;
    char n = 78;

    int i;

//Gib den Wert für i hier ein;
    i = 40;


    while (i>41) { System.out.println(a);}
    do {System.out.print(b);}
    while (i<39);

//Füge einen Wert für j ein.
    int j = 10;

    i = i + j;

    if (i >= 3 && i*i <= 100) {System.out.print(a);}
    else {System.out.print(n);}


    i = (i<5) ? 1 : 0;

    for (i=i; i<2; i++) {System.out.print(n);}

//Füge einen Wert für k ein.
    int k = 3;

    switch(i*k+j) {
        case 4: System.out.print(a+n+a);
        case 3: System.out.print("ANA");
        case 8: System.out.print("ANA");
        case -6: System.out.print("ANA");
    }
}
}
