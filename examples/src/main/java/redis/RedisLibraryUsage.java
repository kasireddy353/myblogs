package redis;

public class RedisLibraryUsage {

    public static void main(String[] args) {
        RedisLibrary redisLibrary = new RedisLibrary("localhost", 6379);
        String response = redisLibrary.setValue("abc", "welcome");
        System.out.println("The response received from Server is:" + response);
    }
}
