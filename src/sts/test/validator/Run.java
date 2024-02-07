package sts.test.validator;

//Simple data class to store information about a test case
class TestCase{
    public byte[] message;
    public boolean expected;
    public String description;
    public TestCase(byte[] message,boolean expected,String description){
        this.message = message;
        this.expected = expected;
        this.description = description;
    }
}

public class Run {
    public static void main(String[] arguments) {

        Validator validator = new CompletedValidator();

        TestCase[] testCases = {
            new TestCase(new byte[]{0x02, 0x05, 0x03, 0x14 },true,"Standard valid message"),
            new TestCase(new byte[]{0x02, 0x10, 0x02, 0x10, 0x03, 0x10, 0x10, 0x03, 0x14 },true,"Escaped chatacters"),
            new TestCase(new byte[]{0x02, 0x03, 0x14 },true,"Empty data"),
            new TestCase(new byte[]{0x02, 0x05, 0x02, 0x03, 0x14 },false,"Unescaped 0x02"),
            new TestCase(new byte[]{0x02, 0x05, 0x03, 0x03, 0x14 },false,"Unescaped 0x03"),
            new TestCase(new byte[]{0x02, 0x05, 0x10, 0x03, 0x14 },false,"Unescaped 0x10"),
            new TestCase(new byte[]{0x02, 0x05, 0x10, 0x0B, 0x03, 0x14 },false,"Escaping an invalid character"),
        };

        int totalPassed = 0;
    
        for(TestCase testCase : testCases){
            boolean valid = validator.isValid(testCase.message);
            totalPassed += valid == testCase.expected ? 1 : 0;
            System.out.println(String.format("Message is valid: %s, Expected: %s, Description: %s",
                valid,
                testCase.expected,
                testCase.description
            ));
        }
        System.out.println(String.format("%d/%d tests passed",totalPassed,testCases.length));    
      }
}