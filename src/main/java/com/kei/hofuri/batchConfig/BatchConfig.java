package com.kei.hofuri.batchConfig;

import com.kei.hofuri.hofuriTasklet.CpBalanceTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
  private final JobBuilderFactory jobBuilderFactory;

  private final StepBuilderFactory stepBuilderFactory;

  private final CpBalanceTasklet cpBalanceTasklet;

  public BatchConfig(JobBuilderFactory jobBuilderFactory,
                     StepBuilderFactory stepBuilderFactory,
                     CpBalanceTasklet cpBalanceTasklet) {
    this.jobBuilderFactory = jobBuilderFactory;
    this.stepBuilderFactory = stepBuilderFactory;
    this.cpBalanceTasklet = cpBalanceTasklet;
  }

  @Bean
  public Job CpBalanaceJob(Step cpBalanceStep) {
    return jobBuilderFactory.get("cpBalanceJob") //Job名を指定
        .flow(cpBalanceStep)                     //実行するStepを指定
        .end()
        .build();
  }

  @Bean
  public Step CpBalanceStep() {
    return stepBuilderFactory.get("cpBalanceStep") //Step名を指定
        .tasklet(cpBalanceTasklet)                 //実行するTaskletを指定
        .build();
  }
}