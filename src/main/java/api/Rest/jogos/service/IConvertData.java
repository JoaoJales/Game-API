package api.Rest.jogos.service;

public interface IConvertData {
    <T> T getData (String json, Class<T> tClass);
}
