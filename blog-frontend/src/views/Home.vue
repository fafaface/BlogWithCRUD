<template>
  <div class="home">
    <v-carousel cycle height="720" show-arrows-on-hover>
      <v-carousel-item
        v-for="(item, i) in items"
        :key="i"
        :src="item.src"
        reverse-transition="fade-transition"
        transition="fade-transition"
      ></v-carousel-item>
    </v-carousel>
  </div>
</template>


<script>
export default {
  data() {
    return {
      items: [
        {
          src:
           "http://www.aliceshair.com/Manual/1.jpg",
        },
        {
          src:
            "http://www.aliceshair.com/Manual/2.gif",
        },
        {
          src:
            "http://www.aliceshair.com/Manual/3.jpg",
        },
        {
          src:
            "http://www.aliceshair.com/Manual/4.jpg",
        },
      ],
    };
  },
};
</script>

<style scoped>
.home {
  max-width: 960px;
  padding-top: 30px;
  margin: auto;
}
</style>