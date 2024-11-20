package dev.pollito.user_manager_backend.errordecoder;

import dev.pollito.user_manager_backend.exception.JsonPlaceholderException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.jetbrains.annotations.NotNull;

public class JsonPlaceholderErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String s, @NotNull Response response) {
    return new JsonPlaceholderException(response.status());
  }
}
