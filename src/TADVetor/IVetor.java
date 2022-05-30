package TADVetor;

public interface IVetor {

    Object elemAtRank(Integer r) throws VetorVazioException;
    Object replaceAtRank(Integer r, Object o) throws VetorVazioException;
    void insertAtRank(Integer r, Object o) throws VetorVazioException;
    Object removeAtRank(Integer r) throws VetorVazioException;
}
