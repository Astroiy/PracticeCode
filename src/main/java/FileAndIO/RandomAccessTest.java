package FileAndIO;

import java.io.*;
import java.time.LocalDate;

public class RandomAccessTest {
    // char数量
    public static final int NAME_SIZE = 40;
    // byte数量
    public static final int RECORD_SIZE = 100;

    public static void main(String[] args) throws IOException {
        TextFileTest.Employee[] staff = new TextFileTest.Employee[3];

        staff[0] = new TextFileTest.Employee("Harry Hacker", 35500d, LocalDate.of(1989, 10, 1));
        staff[1] = new TextFileTest.Employee("Carl Cracker", 75000d, LocalDate.of(1987, 12, 15));
        staff[2] = new TextFileTest.Employee("Tony Tester", 30000d, LocalDate.of(1990, 3, 15));

        try(var out = new DataOutputStream(new FileOutputStream(
                System.getProperty("user.dir")+"/IOPractice/employeeListNee.bat"
        ))){
            for (TextFileTest.Employee e : staff) {
                writeData(out,e);
            }
        }

        try(var in = new RandomAccessFile(
                System.getProperty("user.dir")+"/IOPractice/employeeListNee.bat","r"
        )){
            int n = (int)(in.length() / RECORD_SIZE);
            TextFileTest.Employee[] newStaff = new TextFileTest.Employee[n];

            for (int i = 0; i < n; i++) {
                newStaff[i] = new TextFileTest.Employee();

                in.seek((long)i*RECORD_SIZE);
                newStaff[i] = readData(in);
            }

            for (TextFileTest.Employee employee : newStaff) {
                System.out.println(employee);
            }
        }
    }

    public static void writeData(DataOutput out,TextFileTest.Employee e) throws IOException {
        DataIO.writeFixedString(e.getName(),NAME_SIZE,out);
        out.writeDouble(e.getSalary());

        LocalDate date = e.getDate();
        out.writeInt(date.getYear());
        out.writeInt(date.getMonthValue());
        out.writeInt(date.getDayOfMonth());
    }

    public static TextFileTest.Employee readData(DataInput in) throws IOException {
        String name = DataIO.readFixedString(NAME_SIZE, in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new TextFileTest.Employee(name,salary,LocalDate.of(y,m,d));

    }
}

