package sim85.core;

public class Registers {
    private int A, B, C, D, E, H, L; // 8-bit registers
    private int PC,SP;

    private int I; // For Immediate Data will be set 
    //and used from cpu to store immediate data for streamline

    public enum Reg {
        A, B, C, D, E, H, L, PC, SP, M, I
    }//M for placeholder for memory
    public void incrementRegister(Reg register)
    {
        switch (register) {
            case A-> A=(A+1)& 0xFF;
            case B-> B=(B+1)& 0xFF;
            case C-> C=(C+1)& 0xFF;
            case D-> D=(D+1)& 0xFF;
            case E-> E=(E+1)& 0xFF;
            case H-> H=(H+1)& 0xFF;
            case L-> L=(L+1)& 0xFF;
            case PC-> PC=(PC+1)& 0xFFFF;
            case SP-> SP=(SP+1)& 0xFFFF;
            default-> throw new IllegalArgumentException("Invalid register: " + register);
        }
    }
    public void decrementRegister(Reg register)
    {
        switch (register) {
            case A-> A=(A-1)& 0xFF;
            case B-> B=(B-1)& 0xFF;
            case C-> C=(C-1)& 0xFF;
            case D-> D=(D-1)& 0xFF;
            case E-> E=(E-1)& 0xFF;
            case H-> H=(H-1)& 0xFF;
            case L-> L=(L-1)& 0xFF;
            case PC-> PC=(PC-1)& 0xFFFF;
            case SP-> SP=(SP-1)& 0xFFFF;
            default-> throw new IllegalArgumentException("Invalid register: " + register);
        }
    }
    public int get(Reg register) {
        switch (register) {
            case A: return A;
            case B: return B;
            case C: return C;
            case D: return D;
            case E: return E;
            case H: return H;
            case L: return L;
            case I: return I;
            case PC: return PC;
            case SP: return SP;
            default: throw new IllegalArgumentException("Invalid register: " + register);
        }
    }

    public void set(Reg register, int value) {
        switch (register) {
            case A -> A = value & 0xFF;
            case B -> B = value & 0xFF;
            case C -> C = value & 0xFF;
            case D -> D = value & 0xFF;
            case E -> E = value & 0xFF;
            case H -> H = value & 0xFF;
            case L -> L = value & 0xFF;
            case I -> I = value & 0xFF;
            case PC -> PC = value & 0xFFFF;
            case SP -> SP = value & 0xFFFF;
            default -> throw new IllegalArgumentException("Invalid register: " + register);
        }
    }
    
    public int getPair(Reg high, Reg low) {
    return (get(high) << 8) | get(low);
    }

    public void setPair(Reg high, Reg low, int value) {
        set(high, (value >> 8) & 0xFF);
        set(low, value & 0xFF);
    }
    public void reset()
    {
        SP=PC=A=B=C=D=E=H=L=I=0;
    }

}
