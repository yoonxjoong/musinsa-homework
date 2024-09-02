import { createRouter, createWebHistory } from 'vue-router';

const routes = [
    {
        path: '/',
        name: 'Home',
        component: () => import('./views/Home.vue')
    },
    {
        path: '/lowest-price-by-category',
        name: 'LowestPriceByCategory',
        component: () => import('./views/LowestPriceByCategory.vue')
    },
    {
        path: '/lowest-sum-price-by-brand',
        name: 'LowestSumPriceByBrand',
        component: () => import('./views/LowestSumPriceByBrand.vue')
    },
    {
        path: '/lowest-and-highest-price-by-brand',
        name: 'LowestAndHighestPriceByBrand',
        component: () => import('./views/LowestAndHighestPriceByBrand.vue')
    },
    {
        path:'/commodity-list',
        name: 'CommodityList',
        component: () => import('./views/CommodityList.vue')
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
