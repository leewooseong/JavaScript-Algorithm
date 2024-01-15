package swea.pn13072;

import java.util.ArrayList;
import java.util.List;

class UserSolution
{
	class Soldier {
		private int mID;	// mID : 고유번호 (1 ≤ mID ≤ 100,000)
		private int mTeam;  // mTeam : 소속팀 (1 ≤ mTeam ≤ 5)
		private int mScore; // mScore : 평판 점수 (1 ≤ mScore ≤ 5)
		
		public Soldier(int mID, int mTeam, int mScore) {
			this.mID = mID;
			this.mTeam = mTeam;
			this.mScore = mScore;
		}
		
		public int getmID() {
			return mID;
		}
		public void setmID(int mID) {
			this.mID = mID;
		}
		public int getmTeam() {
			return mTeam;
		}
		public void setmTeam(int mTeam) {
			this.mTeam = mTeam;
		}
		public int getmScore() {
			return mScore;
		}
		public void setmScore(int mScore) {
			this.mScore = mScore;
		}
		
		@Override
		public String toString() {
			return "Soldier : " + this.getmID() + " " + this.getmTeam() + " " + this.getmScore();
		}
	}
	
	private List<Soldier> sList = new ArrayList<Soldier>();
	
	public void init()
	{
		sList.clear();
	}
	
	public void hire(int mID, int mTeam, int mScore)
	{
		Soldier hiredS = new Soldier(mID, mTeam, mScore);
		sList.add(hiredS);
		
//		System.out.print("sList 출력 : ");
//		sList.stream().forEach(s -> {
//			System.out.print(s.getmID() + " ");
//		});
//		System.out.println();
	}
	
	public void fire(int mID)
	{
		int listIndex = findSoldier(mID);
		sList.remove(listIndex);
		
//		System.out.print("sList 출력 : ");
//		sList.stream().forEach(s -> {
//			System.out.print(s.getmID() + " ");
//		});
//		System.out.println();
	}

	public void updateSoldier(int mID, int mScore)
	{
		int listIndex = findSoldier(mID);
		sList.get(listIndex).setmScore(mScore);
	}

	public void updateTeam(int mTeam, int mChangeScore)
	{
		for (int i = 0; i < sList.size(); i++) {
			Soldier s = sList.get(i);
			if (s.getmTeam() == mTeam) {
				int changedValue = s.getmScore() + mChangeScore;
				if (changedValue > 5) {
					changedValue = 5;
				} else if (changedValue < 1) {
					changedValue = 1;
				}
				s.setmScore(changedValue);
			}
		}
	}
	
	public int bestSoldier(int mTeam)
	{
		Soldier bestS = null;
		
		for (int i = 0; i < sList.size(); i++) {
			Soldier s = sList.get(i);
			
			if (s.getmTeam() == mTeam) {
				if(bestS == null) {
					bestS = s;
				} else {					
					if (bestS.getmScore() < s.getmScore()) {
						bestS = s;
					} else if (bestS.getmScore() == s.getmScore()) {
						bestS = bestS.getmID() > s.getmID() ? bestS : s;
					}
				}
			}
		}
		
		return bestS.getmID();
	}
	
	private int findSoldier(int mID) {
		for (int i = 0; i < sList.size(); i++) {
			if (sList.get(i).getmID() == mID) {				
				return i;
			}  
		}
		
		return -1;
	}
}

