import java.util.*;
import java.io.*;

public class Solver {
	public static long n=100001;
	public static ArrayList<Long> siprim() {
		//int n=(int)Math.floor(Math.sqrt(m)+1);
		boolean[] a=new boolean[(int)n+1];
		for(int i=0;i<=n;i++) {
			a[i]=true;
		}
		
		for(int p=2;p*p<n;p++) {
			if(a[p]==true) {
				for(int i=p*p;i<n;i+=p) {
					a[i]=false;					
				}	
			}			
		}
		ArrayList<Long> arr=new ArrayList<>();
		//System.out.println("sprim:");
		for(long i=2;i<=n;i++) {
			if(a[(int)i]==true) {	
				arr.add(i);
				//System.out.println(i);
			}
		}
		return arr;
	}
	
	public static void siprime(long l,long r) {
		boolean[] arr1=new boolean[(int)(r-1)+1];
		ArrayList<Long> list =new ArrayList<Long>();
		list.addAll(siprim());

		for(long i=0;i<=r-l;i++) {
			arr1[(int)i]=true;
		}
		
		for(int i=0;list.get(i)*list.get(i)<=r;i++) {
			
			long curP=list.get(i);
			long base=(l/curP)*curP;
			if(base<l) {
				base=base+curP;
			}
			for(long j=base;j<=r;j+=curP) {
				arr1[(int)(j-l)]=false;
			}
			if(base==curP) {
				arr1[(int)(base-l)]=true;
			}
		}
		//System.out.println("sprime");
		for(long i=0;i<=r-l;i++) {
			if(arr1[(int)i]==true&&(i+l)!=1) {
				System.out.println(i+l);
			}
		}
	}

	
	public static void main(String[] args) throws IOException{
		Reader sc=new Reader();
		PrintWriter out=new PrintWriter(System.out,true);
		

		long h=sc.nextLong();
		long g=sc.nextLong();
		siprime(h,g);
		System.out.println();
		
	}
}
class Reader
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;
 
    public Reader()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }
 
    public Reader(String file_name) throws IOException
    {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }
 
    public String readLine() throws IOException
    {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1)
        {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }
 
    public int nextInt() throws IOException
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do
        {
            ret = ret * 10 + c - '0';
        }  while ((c = read()) >= '0' && c <= '9');
 
        if (neg)
            return -ret;
        return ret;
    }
 
    public long nextLong() throws IOException
    {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }
 
    public double nextDouble() throws IOException
    {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
 
        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
 
        if (c == '.')
        {
            while ((c = read()) >= '0' && c <= '9')
            {
                ret += (c - '0') / (div *= 10);
            }
        }
 
        if (neg)
            return -ret;
        return ret;
    }
 
    private void fillBuffer() throws IOException
    {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }
 
    private byte read() throws IOException
    {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }
 
    public void close() throws IOException
    {
        if (din == null)
            return;
        din.close();
    }
}

