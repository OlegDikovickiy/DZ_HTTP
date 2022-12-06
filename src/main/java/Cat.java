import com.fasterxml.jackson.annotation.JsonProperty;

public class Cat {
  private final String id;
  private final String text;
  private final String type;
  private final String user;
  private final int voice;

  public Cat(
      @JsonProperty("id") String id,
      @JsonProperty("text") String text,
      @JsonProperty("type") String type,
      @JsonProperty("user") String user,
      @JsonProperty("upvotes") int voice
  ) {
    this.id = id;
    this.text = text;
    this.type = type;
    this.user = user;
    this.voice = voice;
  }

  public int getVoice() {
    return voice;
  }

  @Override
  public String toString() {
    return "\n Cat" +
        "\n id: " + id +
        "\n text: " + text +
        "\n type: " + type +
        "\n user: " + user +
        "\n upvotes: " + voice;
  }
}
