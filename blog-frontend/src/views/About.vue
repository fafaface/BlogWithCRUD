<template>
  <div class="about" >

        <div class="div0">
          <v-card max-width="460" class="mx-auto">
            <v-list>
              <v-list-item>
                <v-list-item-icon>
                  <v-icon color="indigo">mdi-account-circle-outline </v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title>连月菡</v-list-item-title>
                  <v-list-item-subtitle>姓名</v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>
              <v-divider inset></v-divider>
              <v-list-item>
                <v-list-item-icon>
                  <v-icon color="indigo"> mdi-phone </v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title>+86-156-0609-1234</v-list-item-title>
                  <v-list-item-subtitle>联系电话</v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>
              <v-divider inset></v-divider>

              <v-list-item>
                <v-list-item-icon>
                  <v-icon color="indigo"> mdi-email </v-icon>
                </v-list-item-icon>

                <v-list-item-content>
                  <v-list-item-title>lianyuehan@outlook.com</v-list-item-title>
                  <v-list-item-subtitle>电子邮箱</v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>
              <v-divider inset></v-divider>

              <v-list-item>
                <v-list-item-icon>
                  <v-icon color="indigo"> mdi-map-marker </v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title
                    >北京市海淀区清华东路35号北京林业大学</v-list-item-title
                  >
                  <v-list-item-subtitle>现居地</v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>
              <v-divider inset></v-divider>

              <v-list-item>
                <v-list-item-icon>
                  <v-icon color="indigo"> mdi-doctor </v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title>计算机科学与技术</v-list-item-title>
                  <v-list-item-subtitle>专业</v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>
              <v-divider inset></v-divider>

              <v-list-item>
                <v-list-item-icon>
                  <v-icon color="indigo"> mdi-flag </v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title
                    >正在寻找一个后端开发的实习机会</v-list-item-title
                  >
                  <v-list-item-subtitle>动态</v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>
              <v-divider inset></v-divider>

              <v-list-item>
                <v-list-item-icon>
                  <v-icon color="indigo"> mdi-book </v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title
                    >最近正在学习 Unix 环境编程</v-list-item-title
                  >
                  <v-list-item-subtitle>方向</v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>

              <v-divider inset></v-divider>

              <v-list-item>
                <v-list-item-icon>
                  <v-icon color="indigo"> mdi-heart </v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title
                    >听不同流派的歌，纯文学，看电影</v-list-item-title
                  >
                  <v-list-item-subtitle>爱好</v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>

              <v-divider inset></v-divider>

              <v-list-item>
                <v-list-item-icon>
                  <v-icon color="indigo"> mdi-radio </v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title>张悬、窦唯、郑宜农</v-list-item-title>
                  <v-list-item-subtitle>喜欢的歌手</v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>

              <v-divider inset></v-divider>

              <v-list-item>
                <v-list-item-icon>
                  <v-icon color="indigo"> mdi-star </v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                  <v-list-item-title
                    >星之卡比、Tonesphere、命运石之门</v-list-item-title
                  >
                  <v-list-item-subtitle>喜欢的游戏</v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>
            </v-list>
          </v-card>
        </div>
        <div class="div0">
          <v-img
            src="http://www.aliceshair.com/about/selfile.jpg"
            height="638"
            width="500"
            dark
          >
          </v-img></div
      >
  </div>
</template>

<style >
.about{
  padding-top: 30px;
  margin: auto;
  display:flex;
  justify-content:center;

}
.div0 {
  padding: 10px;

}
</style>