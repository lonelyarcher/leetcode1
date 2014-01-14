package Leetcode;

import java.util.ArrayList;
import java.util.Iterator;

import Leetcode.customerDataType.Interval;

public class InsertInterval
{

	public static void main(String[] args)
	{
		ArrayList<Interval> intervals=new ArrayList<Interval>();

		intervals.add(new Interval(1, 5));
		intervals.add(new Interval(6, 8));
		for (Interval i : insert(intervals, new Interval(5, 6)))
			System.out.println(i.start+" "+i.end);

	}

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval)
	{
		int n=intervals.size();
		if(n==0||newInterval.start>=intervals.get(n-1).end)
		{
			intervals.add(newInterval);
			return intervals;
		}
		if(newInterval.end<intervals.get(0).start)
		{
			intervals.add(0, newInterval);
			return intervals;
		}

		Iterator<Interval> iter=intervals.iterator();
		int pos=-1;
		int i=0;
		while (iter.hasNext())
		{
			Interval interval=iter.next();
			if(interval.end>=newInterval.start&&interval.start<=newInterval.end)
			{
				if(pos==-1) pos=i;
				newInterval.start=Math.min(newInterval.start, interval.start);
				newInterval.end=Math.max(newInterval.end, interval.end);
				iter.remove();
			}
			if(interval.start>newInterval.start&&pos==-1) pos=i-1;
			i++;
		}
		intervals.add(pos, newInterval);
		return intervals;
	}

}
