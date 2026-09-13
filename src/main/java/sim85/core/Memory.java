package sim85.core;

public class Memory {
    private int[] memory ; // 64KB of memory
    final private int size=65536;
    public Memory()
    {
        memory= new int[size];
    }
    public int read(int address) {
        return memory[address & 0xFFFF];
    }

    public void write(int address, int value) {
        memory[address & 0xFFFF] = value & 0xFF; // Ensure value is 8-bit
    }

    public void reset() {
        java.util.Arrays.fill(memory, 0);
    }

    public int size() {
        return size;
    }
    public int[] getCompleteMemory()
    {
        return memory;
    }
    public void setCompleteMemory(int [] memory)
    {
        this.memory=memory;
    }
}
