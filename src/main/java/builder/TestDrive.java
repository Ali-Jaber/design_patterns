package builder;

public class TestDrive {
    public static void main(String[] args) {

        AlertDialog twoButtonsDialog = new AlertDialog.Builder().
                setText("Two buttons dialog").
                setTitle("You can use either `Okay` or `Cancel`")
                .setApplyButton("Okay")
                .setCancelButton("Cancel").
                        build();

        System.out.println(twoButtonsDialog);

        AlertDialog oneButtonDialog = new AlertDialog.Builder().
                setText("Two buttons dialog")
                .setTitle("You can use `Close` only")
                .setCancelButton("Close")
                .build();
        System.out.println(oneButtonDialog);
    }
}
