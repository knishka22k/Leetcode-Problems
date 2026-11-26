class Solution {
    public boolean canAliceWin(int n) {
        int stoneRemove = 10; //given 
        boolean aliceTurn = true;
        while(n >= stoneRemove){
            n -= stoneRemove; //1st turn
            stoneRemove--; //remove by 1 
            aliceTurn = !aliceTurn; //turn change 
        }
        return !aliceTurn;
    }
}