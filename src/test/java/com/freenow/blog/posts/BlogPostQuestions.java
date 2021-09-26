package com.freenow.blog.posts;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BlogPostQuestions {

  @Step("Get a postId from the response")
  public String getPostId(Response postDetailsResp) {
    return postDetailsResp.getBody().jsonPath().get("[0].id").toString();
  }

  @Step("Verify userId for each post is matching the owner userId")
  public void verifyUserIdInPosts(List<Object> posts) {
    for (Object o : posts) {
      Map post = (Map) o;
      assertThat(post.get("userId").toString())
          .isEqualTo(Serenity.sessionVariableCalled("userId").toString());
    }
  }
}
