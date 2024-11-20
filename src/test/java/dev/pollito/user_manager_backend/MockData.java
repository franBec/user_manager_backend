package dev.pollito.user_manager_backend;

import com.typicode.jsonplaceholder.model.User;
import java.util.List;

public class MockData {
  private MockData() {}

  private static final User USER_1 =
      new User().id(1).name("Leanne Graham").username("Bret").email("Sincere@april.biz");

  private static final User USER_2 =
      new User().id(2).name("Ervin Howell").username("Antonette").email("Shanna@melissa.tv");

  private static final User USER_3 =
      new User().id(3).name("Clementine Bauch").username("Samantha").email("Nathan@yesenia.net");

  private static final User USER_4 =
      new User()
          .id(4)
          .name("Patricia Lebsack")
          .username("Karianne")
          .email("Julianne.OConner@kory.org");

  private static final User USER_5 =
      new User()
          .id(5)
          .name("Chelsey Dietrich")
          .username("Kamren")
          .email("Lucio_Hettinger@annie.ca");

  private static final User USER_6 =
      new User()
          .id(6)
          .name("Mrs. Dennis Schulist")
          .username("Leopoldo_Corkery")
          .email("Karley_Dach@jasper.info");

  private static final User USER_7 =
      new User()
          .id(7)
          .name("Kurtis Weissnat")
          .username("Elwyn.Skiles")
          .email("Telly.Hoeger@billy.biz");

  private static final User USER_8 =
      new User()
          .id(8)
          .name("Nicholas Runolfsdottir V")
          .username("Maxime_Nienow")
          .email("Sherwood@rosamond.me");

  private static final User USER_9 =
      new User()
          .id(9)
          .name("Glenna Reichert")
          .username("Delphine")
          .email("Chaim_McDermott@dana.io");

  private static final User USER_10 =
      new User()
          .id(10)
          .name("Clementina DuBuque")
          .username("Moriah.Stanton")
          .email("Rey.Padberg@karina.biz");

  public static final List<User> USERS =
      List.of(USER_1, USER_2, USER_3, USER_4, USER_5, USER_6, USER_7, USER_8, USER_9, USER_10);
}
