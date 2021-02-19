<template>
  <div class="resume">
    <v-card>
      <v-tabs vertical>
        <v-tab>
          <v-icon left> mdi-book-education-outline </v-icon>
          学习成绩
        </v-tab>
        <v-tab>
          <v-icon left> mdi-badge-account-horizontal-outline </v-icon>
          科研经历
        </v-tab>
        <v-tab>
          <v-icon left> mdi-trophy-variant </v-icon>
          获奖情况
        </v-tab>

        <v-tab-item>
          <v-card flat>
            <v-container>
              <CreateCourseItem
                v-if="$store.getters.isAdmin"
                @course-changed="fetchData"
              />
              <div class="text-center" v-if="loading">
                <v-progress-circular indeterminate color="primary" />
              </div>
              <template v-if="courses">
                <CourseItem
                  v-for="course in courses"
                  :key="course.id"
                  :id="course.id"
                  :name="course.name"
                  :grade="course.grade"
                  @course-changed="fetchData"
                  class="mb-4"
                />
              </template>
            </v-container>
          </v-card>
        </v-tab-item>
        <v-tab-item>
          <v-card flat>
            <v-container>
              <CreateExperienceItem
                v-if="$store.getters.isAdmin"
                @experience-changed="fetchData"
              />
              <div class="text-center" v-if="loading">
                <v-progress-circular indeterminate color="primary" />
              </div>
              <template v-if="experiences">
                <ExperienceItem
                  v-for="experience in experiences"
                  :key="experience.id"
                  :id="experience.id"
                  :title="experience.title"
                  :startDate="experience.startDate"
                  :endDate="experience.endDate"
                  :institution="experience.institution"
                  :role="experience.role"
                  :description="experience.description"
                  @experience-changed="fetchData"
                  class="mb-4"
                />
              </template>
            </v-container>
          </v-card>
        </v-tab-item>
        <v-tab-item>
          <v-card flat>
            <v-container>
              <CreateAwardItem
                v-if="$store.getters.isAdmin"
                @award-changed="fetchData"
              />
              <div class="text-center" v-if="loading">
                <v-progress-circular indeterminate color="primary" />
              </div>
              <template v-if="awards">
                <AwardItem
                  v-for="award in awards"
                  :key="award.id"
                  :id="award.id"
                  :title="award.title"
                  :awardDate="award.awardDate"
                  @award-changed="fetchData"
                  class="mb-4"
                />
              </template>
            </v-container>
          </v-card>
        </v-tab-item>
      </v-tabs>
    </v-card>
  </div>
</template>

<script>
import CourseItem from "../components/CourseItem.vue";
import CreateCourseItem from "../components/CreateCourseItem.vue";

import ExperienceItem from "../components/ExperienceItem.vue";
import CreateExperienceItem from "../components/CreateExperienceItem.vue";

import AwardItem from "../components/AwardItem.vue";
import CreateAwardItem from "../components/CreateAwardItem.vue";

export default {
  components: {
    CreateCourseItem,
    CourseItem,
    ExperienceItem,
    CreateExperienceItem,
    AwardItem,
    CreateAwardItem,
  },

  data: function () {
    return {
      loading: false,
      courses: null,
      awards: null,
      experiences: null,
      error: null,
      dialog: false,
    };
  },

  created: function () {
    this.fetchData();
  },

  watch: {
    $route: "fetchData",
    selected: "fetchData",
  },

  methods: {
    fetchData: async function () {
      // error暂时没处理
      this.error = this.courses = null;
      // this.error = this.awards = null;
      // this.error = this.experiences = null;

      this.loading = true;

      const courseResp = await fetch(`/api/courses`);
      const courseRespData = await courseResp.json();
      this.courses = courseRespData.sort((a, b) => b.id - a.id);

      const awardResp = await fetch(`/api/awards`);
      const awardRespData = await awardResp.json();
      this.awards = awardRespData.sort((a, b) => b.id - a.id);

      const experienceResp = await fetch(`/api/experiences`);
      const experienceRespData = await experienceResp.json();
      this.experiences = experienceRespData.sort((a, b) => b.id - a.id);
      this.loading = false;
    },
  },
};
</script>
<style scoped>
.resume {
  max-width: 960px;
  padding-top: 30px;
  margin: auto;
}
</style>