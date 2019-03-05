package com.unicdata.configaration;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.AbstractPathProvider;
import springfox.documentation.spring.web.paths.Paths;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swaggers 配置
 *
 * @author 申勇
 * @date 2018年5月30日
 */
@Configuration
@EnableSwagger2
public class Swaggers {

    // 版本号
    @Value("${swagger.version}")
    private String version;

    // 项目请求地址
    @Value("${swaggers.request.base.url}")
    private String baseUrl;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 重写BASE URL
//				.pathProvider(new BasePathAwareRelativePathProvider(baseUrl))
                .apiInfo(apiInfo())
                //.enableUrlTemplating(true)
                .select()
                // 扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 首页描述
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("如来后台管理前端接口api")
                .description("如来后台管理前端接口api")
                .termsOfServiceUrl("http://www.unicdata.com/")
                .contact("好好享受代码带来的乐趣吧！")
                .version(version)
                .build();
    }

    /**
     * 重写BASE URL
     *
     * @author 申勇
     * @date 2018年3月16日
     */
    class BasePathAwareRelativePathProvider extends AbstractPathProvider {
        private String basePath;

        public BasePathAwareRelativePathProvider(String basePath) {
            this.basePath = basePath;
        }

        @Override
        protected String applicationPath() {
            return basePath;
        }

        @Override
        protected String getDocumentationPath() {
            return "/";
        }

        @Override
        public String getOperationPath(String operationPath) {
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/");
            return Paths.removeAdjacentForwardSlashes(
                    uriComponentsBuilder.path("").build().toString());
        }
    }
}
