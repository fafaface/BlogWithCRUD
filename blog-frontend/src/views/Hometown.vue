<template>
  <div class="hometown">
    <v-sheet class="mx-auto" elevation="12" max-width="1280">
      <v-slide-group center-active v-model="model" class="pa-4" show-arrows>
        <v-slide-item v-for="(item, i) in items" :key="i">
          <v-card class="ma-4" height="300" width="480" @click="toggle">
            <v-row class="fill-height" align="center" justify="center">
              <v-img :src="items[i].src"></v-img
            ></v-row>
          </v-card>
        </v-slide-item>
      </v-slide-group>

      <div class="introduction">
        <v-card class="mx-auto" max-width="960" outlined>
          <v-list-item three-line>
            <v-list-item-content>
              <v-list-item-title class="headline mb-1">
                福建·南平
              </v-list-item-title>
              <v-list-item-content class="body-1">
                <v-list-item-content class="body-1">
                  建阳区是中华人民共和国福建省南平市的一个市辖区，南平市人民政府驻地。别称大潭、潭阳、潭城，位于武夷山脉南麓，地处闽北中心。
                  常住人口 34.7 万人，其中本地户籍人口 34.52
                  万人，居民以汉族为主。建城于公元 205 年，迄今 1800
                  多年，是福建省最早的县邑之一，
                  受闽越文化影响深厚，在闽北地区占据重要地位。历史上建盏工艺、印刷业和理学教育高度发达，在国内闻名遐迩，有南闽阙里之称。
                </v-list-item-content>
                <v-divider inset></v-divider>
                <v-list-item-content class="body-1">
                  <h5 class="white text-center py-2">印刷业</h5>
                  明代建阳进德堂刻印的《玉篇》
                  宋代以来，建阳一直是重要的印刷集中地。
                  历史上，由于造纸业、制墨业的发达，为印刷业提供了充足的纸张。唐宋以来理学在建阳的发展，也为印刷业扩张提供了契机。明代是建阳印刷业的黄金时期，有堂号姓名可考者约四十八家，主要是余氏、刘氏、叶氏、熊氏等。这一时期，建阳以刻印小说、故事，百科大全等民间读物为主。书坊主人时常自编自刻，由话本演变成为小说后，又经增补缀编为演义之类的书籍，这在另一方面也促进了建阳文学的发展。到了明代后期，由于其他地区印刷业的发展，使这里的书籍销量大减，使建阳印刷业有所没落。
                </v-list-item-content></v-list-item-content
              ><v-divider inset></v-divider>
              <v-list-item-content class="body-1">
                <h5 class="white text-center py-2">文学</h5>
                唐代以后大量文人的南下使得建阳文学初兴。南宋时期，伴随着理学的兴起，朱熹、游酢等理学名家在建阳著有了许多作品，《四书集注》等理学经典亦是首先在建阳刻印发行。朱熹在建阳讲学，使建阳很快成为当时理学的重要基地，聚集了朱熹、蔡元定、刘爚、黄干、游九言、叶味道为首的考亭学派重要人物，并产生了《云谷记》《游百丈山记》等以建阳县域为背景的著名作品。
                同时，宋慈所撰的《洗冤集录》，为世界现存最早最系统的法医学著作，为建阳文化史增添光彩，更使建阳有“海滨邹鲁”的美誉。
              </v-list-item-content>
              <v-divider inset></v-divider>
              <v-list-item-content class="body-1">
                <h5 class="white text-center py-2">语言</h5>
                建阳话是闽北语的一种方言，是闽北语的建阳音。建阳话与闽东语、闽南语虽然都是闽语的分支，但差异极大，不经过专门学习，彼此根本无法通话。建阳话与现代标准汉语相比，有些字词发音类似，但更多的字词发音差异极大，两者无法互通理解。目前主要应用于农村地区。
              </v-list-item-content>
            </v-list-item-content>
          </v-list-item>
        </v-card>
      </div>
    </v-sheet>
  </div>
</template>
<script>
export default {
  data() {
    return {
      items: [
        {
          src: "https://icweiliimg6.pstatp.com/weili/l/891512838472859747.webp",
        },
        {
          src:
            "https://weiliicimg6.pstatp.com/weili/l/1023904140249792620.webp",
        },
        {
          src: "https://weiliicimg6.pstatp.com/weili/l/255032667020066929.webp",
        },

        {
          src: "https://icweiliimg1.pstatp.com/weili/l/922625530058899482.webp",
        },
        {
          src: "https://weiliicimg9.pstatp.com/weili/l/742360761887883268.webp",
        },
        {
          src: "https://weiliicimg9.pstatp.com/weili/l/688931205520162837.webp",
        },
        {
          src: "https://icweiliimg9.pstatp.com/weili/l/936011869377658891.webp",
        },
        {
          src: "http://photocdn.sohu.com/20151014/mp35587221_1444802620843_2.jpeg",
        },
      ],
    };
  },
};
</script>
<style scoped>
.introduction,
.hometown {
  max-width: 1080px;
  padding-top: 30px;
  margin: auto;
}
</style>