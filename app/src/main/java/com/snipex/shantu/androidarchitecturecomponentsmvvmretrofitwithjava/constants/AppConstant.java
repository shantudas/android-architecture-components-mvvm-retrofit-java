package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.constants;

public class AppConstant {

    /**
     * get a api key from https://newsapi.org/
     * just register an account and request for an api key
     * when you will get an api key please replace with YOUR_API_KEY
     */
    public static final String BASE_URL = "https://newsapi.org/";
    public static final String API_KEY = "494d8b052f544a4e9848574a6c4930bc";
    public static final String ARTICLE_COUNTRY= "us";
    public static final String ARTICLE_QUERY = "movies";

    public static class Query{
        public static final String HEADLINES = "headlines";
    }
}
