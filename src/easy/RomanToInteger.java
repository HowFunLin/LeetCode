package easy;

public class RomanToInteger
{
	public static void main(String[] args)
	{
		RomanToInteger rti = new RomanToInteger();
		System.out.println(rti.romanToInt("MCMXCIV"));
	}

	public int romanToInt(String s) {
        char[] str = s.toCharArray();
        int len = str.length, number = 0;
        for(int i=0;i<len;i++){
            switch(str[i]){
                case 'M': number+=1000; break;
                case 'D': number+=500; break;
                case 'C': 
                    if(i+1<len && (str[i+1]=='M' || str[i+1]=='D'))
                        number-=100;
                    else
                        number+=100;
                    break;
                case 'L': number+=50; break;
                case 'X': 
                    if(i+1<len && (str[i+1]=='C' || str[i+1]=='L'))
                        number-=10;
                    else
                        number+=10;
                    break;
                case 'V': number+=5; break;
                case 'I': 
                    if(i+1<len && (str[i+1]=='V' || str[i+1]=='X'))
                        number-=1;
                    else
                        number+=1;
                    break;
            }
        }
        return number;
    }
	
	/*
	public int romanToInt(String s) 
    {
        int result = 0;
		
		for(int i = 0; i < s.length(); i++)
        {
        	if(i < s.length() - 1)
        	{
        		if(s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') 
                {
                    result += 4;
                    i += 1;
                    continue;
                }
        		if(s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') 
                {
                    result += 9;
                    i += 1;
                    continue;
                }
        		if(s.charAt(i) == 'X' && s.charAt(i + 1) == 'L')
                {
                    result += 40;
                    i += 1;
                    continue;
                }
        		if(s.charAt(i) == 'X' && s.charAt(i + 1) == 'C')
                {
                    result += 90;
                    i += 1;
                    continue;
                }
        		if(s.charAt(i) == 'C' && s.charAt(i + 1) == 'D')
                {
                    result += 400;
                    i += 1;
                    continue;
                }
        		if(s.charAt(i) == 'C' && s.charAt(i + 1) == 'M')
                {
                    result += 900;
                    i += 1;
                    continue;
                }
        	}
            
            if(s.charAt(i) == 'I') result += 1;
        	if(s.charAt(i) == 'V') result += 5;
        	if(s.charAt(i) == 'X') result += 10;
        	if(s.charAt(i) == 'L') result += 50;
        	if(s.charAt(i) == 'C') result += 100;
        	if(s.charAt(i) == 'D') result += 500;
        	if(s.charAt(i) == 'M') result += 1000;
        }
		
		return result;
    }
    */
}
