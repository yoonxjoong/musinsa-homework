<script setup>
import {ref} from 'vue';
import {useRouter} from 'vue-router';

const router = useRouter();
const selectedOption = ref('/');

const handleSelection = (event) => {
  const value = event.target.value;
  router.push(value);
};
</script>

<template>
  <div class="bg-blue-600 text-white p-6 shadow-md">
    <div class="container mx-auto flex items-center justify-between">
      <router-link to="/" class="text-white hover:text-gray-300">
        <h1 class="text-2xl font-bold">Welcome to My Musinsa Homework</h1>
      </router-link>
      <nav class="space-x-4">
        <router-link to="/commodity-list" class="text-white hover:text-gray-300">상품목록</router-link>
        <select
            v-model="selectedOption"
            @change="handleSelection"
            class="bg-blue-700 text-white border border-gray-600 rounded-md p-2"
        >
          <option value="/" disabled>선택해주세요.</option>
          <option value="/lowest-price-by-category">카테고리별 저렴한 브랜드는?</option>
          <option value="/lowest-sum-price-by-brand">전부 구매하면 이 브랜드가 가장 저렴해요!</option>
          <option value="/lowest-and-highest-price-by-brand">카테고리별 브랜드 가격 차이는?</option>
        </select>
      </nav>
    </div>
  </div>

  <router-view></router-view> <!-- 페이지 컴포넌트가 여기에 렌더링 됩니다. -->

</template>

<style scoped>
/* 이 부분은 Tailwind CSS를 사용하므로 여기에 추가 스타일을 넣지 않아도 됩니다. */
</style>
