package unisangil.parcialfinal.models;

public enum TransactionType {
    INCOME,
    EXPENSE;

    public String forHumans() {
        if (this == INCOME) {
            return "Ingreso";
        } else if (this == EXPENSE) {
            return "Egreso";
        } else {
            throw new IllegalArgumentException("Invalid transaction type");
        }
    }
}
