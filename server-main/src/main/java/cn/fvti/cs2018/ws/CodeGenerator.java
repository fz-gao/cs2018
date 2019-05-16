package cn.fvti.cs2018.ws;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        String tableName = scanner("表名");
        String bigHumpTableName = underlineToHump(tableName);

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir") + "/server-main/";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("gsd");
        gc.setOpen(false);
        gc.setServiceName(bigHumpTableName+"Service");
        gc.setServiceImplName(bigHumpTableName+"ServiceImpl");
        gc.setControllerName(bigHumpTableName+"Controller");
        gc.setMapperName(bigHumpTableName+"Mapper");
        gc.setXmlName(bigHumpTableName+"Mapper");
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setIdType(IdType.ID_WORKER);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://120.78.211.69:3306/news?autoReconnect=true&useUnicode=true&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("ai2018");
        dsc.setPassword("helloworld");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("cn.fvti.cs2018.ws");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setXml("mapper.mapping");
        pc.setMapper("mapper");
        pc.setEntity("bean.model");
        pc.setController("web");

        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        //String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";
        // 如果模板引擎是beetl
        String templatePath ="/templates/mapper.xml.btl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/src/main/java/cn/fvti/cs2018/ws/mapper/" + "mapping"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();


        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setSuperControllerClass("cn.fvti.cs2018.ws.web.BaseController");
        strategy.setInclude(tableName);
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("news" + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new BeetlTemplateEngine());
        mpg.execute();
    }


    /**
     * 将下划线命名转化为驼峰命名
     * @param para
     * @return
     */
    public static String underlineToHump(String para){
        StringBuilder result=new StringBuilder();
        String a[]=para.split("_");
        for(int i=0;i<a.length;i++){
            result.append(a[i].substring(0, 1).toUpperCase());
            result.append(a[i].substring(1).toLowerCase());
        }
        return result.toString();
    }
}
