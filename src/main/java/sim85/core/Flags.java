package sim85.core;

public class Flags {
    private boolean Z, S, P, CY, AC; // Zero, Sign, Parity, Carry, Auxiliary Carry flags

    public boolean isZero() { return Z; }
    public void setZero(boolean value) { Z = value; }

    public boolean isSign() { return S; }
    public void setSign(boolean value) { S = value; }

    public boolean isParity() { return P; }
    public void setParity(boolean value) { P = value; }

    public boolean isCarry() { return CY; }
    public void setCarry(boolean value) { CY = value; }

    public boolean isAuxiliaryCarry() { return AC; }
    public void setAuxiliaryCarry(boolean value) { AC = value; }

    public void updateZSP(int result) {
        int masked = result & 0xFF;
        setZero(masked == 0);
        setSign((masked & 0x80) != 0);           // bit 7 set → negative in two's complement
        setParity(Integer.bitCount(masked) % 2 == 0);  // 8085 parity is "even parity": set if even number of 1-bits
    }
    public void updateAllFlags(int result)
    {
        int masked = result & 0x1FF;
        updateZSP(result);
        //setAuxiliaryCarry((masked & 0x10)!=0); //This is wrong
        // Skipping it as it is only used for DAA 
        setCarry((masked & 0x100)!=0);
    }

    public int getPSW()
    {
        int psw=0;
        if(isSign()) psw|=0x80;
        if(isZero()) psw|=0x40;
        if(isAuxiliaryCarry()) psw|=0x10;
        if(isParity()) psw|=0x04;
        psw|=0x02; //for some reason it is to be 1
        if(isCarry()) psw|=0x01;
        return psw;
    }
    public void setPSW(int psw)
    {
        setSign((psw & 0x80) != 0);
        setZero((psw & 0x40) != 0);
        setAuxiliaryCarry((psw & 0x10) != 0);
        setParity((psw & 0x04) != 0);
        setCarry((psw & 0x01) != 0);
    }

    public void reset(){
        Z = S = P = CY = AC = false;
    }
}
