package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Leetcode.customerDataType.Interval;

public class MergeInterval
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals)
	{
		ArrayList<Interval> ret=new ArrayList<Interval>();
		if(intervals.size()==0) return ret;
		Collections.sort(intervals, new Comparator<Interval>()
		{
			@Override
			public int compare(Interval a, Interval b)
			{
				if(a.start>b.start) return 1;
				if(a.start<b.start) return -1;
				return 0;
			}
		});

		int start=intervals.get(0).start;
		int end=intervals.get(0).end;
		for (int i=1; i<intervals.size(); i++)
		{
			if(intervals.get(i).start>end)
			{
				ret.add(new Interval(start, end));
				start=intervals.get(i).start;
				end=intervals.get(i).end;
			}
			else if(intervals.get(i).end>end) end=intervals.get(i).end;
		}
		ret.add(new Interval(start, end));
		return ret;
	}

}
