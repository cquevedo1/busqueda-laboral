package com.cristian.jobsearch;

import com.beust.jcommander.JCommander;
import com.cristian.jobsearch.api.APIJobs;
import com.cristian.jobsearch.cli.CLIArguments;
import com.cristian.jobsearch.cli.CLIFunctions;

import java.util.*;
import java.util.stream.Stream;

import static com.cristian.jobsearch.ComanderFunctions.buildCommanderWithName;
import static com.cristian.jobsearch.ComanderFunctions.parseArguments;
import static com.cristian.jobsearch.api.APIFunctions.buildAPI;

public class JobSearch {
    public static void main(String[] args) {
        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);

        Stream<CLIArguments> streamOfCLI =
                parseArguments(jCommander, args, JCommander::usage)
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(obj -> (CLIArguments) obj);

        Optional<CLIArguments> cliArgumentsOptional =
                streamOfCLI.filter(cli -> !cli.isHelp())
                        .filter(cli -> cli.getKeyword() != null )
                        .findFirst();

        cliArgumentsOptional.map(CLIFunctions::toMap)
                .map(JobSearch::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    private static Stream<JobPosition> executeRequest(Map<String, Object> params) {
        APIJobs apiJobs = buildAPI(APIJobs.class, "https://jobs.github.com/jobs");
        return  Stream.of(params)
                .map(apiJobs::jobs)
                .flatMap(Collection::stream);
    }
}
