<script setup>
import {defineProps} from 'vue';

// 부모 컴포넌트에서 전달한 데이터를 받아올 props 정의
const props = defineProps({
  rows: {
    type: Array,
    required: true
  }
});
</script>

<template>
  <div class="flex flex-col">
    <div class="overflow-x-auto sm:-mx-6 lg:-mx-8">
      <div class="inline-block min-w-full py-2 sm:px-6 lg:px-8">
        <div class="overflow-hidden">
          <table class="min-w-full text-left text-sm font-light">
            <thead class="border-b border-neutral-200 font-medium">
            <tr>
              <th scope="col" class="px-6 py-4">#</th>
              <th scope="col" class="px-6 py-4">카테고리명</th>
              <th scope="col" class="px-6 py-4">가격</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(row, index) in props.rows" :key="index" class="border-b border-neutral-200">
              <td class="whitespace-nowrap px-6 py-4 font-medium">{{ index + 1 }}</td>
              <td class="whitespace-nowrap px-6 py-4">{{ row.categoryNm }}</td>
              <td class="whitespace-nowrap px-6 py-4">{{ row.price.toLocaleString('ko-KR') }}</td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>
