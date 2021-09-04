package main.easy;

/**
 * 
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。 每位顾客只买一杯柠檬水，然后向你付
 * 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。 注意，一开始你手头没有任何零钱。
 * 
 * @author Riyad
 *
 */
public class LemonadeChange
{
	public static void main(String[] args)
	{
		LemonadeChange lc = new LemonadeChange();

		int[] bills =
		{ 5, 5, 10, 10, 20 };

		System.out.println(lc.lemonadeChange(bills));
	}

	/**
	 * 柠檬水找零
	 * 
	 * @param bills 账单支付的顺序
	 * @return 如果你能给每位顾客正确找零，返回 true ，否则返回 false
	 */
	public boolean lemonadeChange(int[] bills)
	{
		int five = 0;
		int ten = 0;

		for (int i = 0; i < bills.length; i++)
		{
			if (bills[i] == 5)
			{
				five++;
			} else if (bills[i] == 10)
			{
				if (five > 0)
				{
					five--;
					ten++;

					continue;
				}

				return false;
			} else
			{
				if (ten > 0 && five > 0)
				{
					ten--;
					five--;

					continue;
				} else if (five > 2)
				{
					five -= 3;

					continue;
				}

				return false;
			}
		}

		return true;
	}
}