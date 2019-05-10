package nl.apocalypsje.bedrock.response.element;

public class Response {

    protected String elementId;

    Response(String elementId) {
        this.elementId = elementId;
    }

    public String getElementId() {
        return this.elementId;
    }

    @Override
    public String toString() {
        return "Response{" +
                "elementId='" + this.elementId + '\'' +
                '}';
    }
}
