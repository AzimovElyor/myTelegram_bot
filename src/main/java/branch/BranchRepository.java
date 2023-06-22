package branch;

import common.BaseRepository;

import java.util.UUID;

public class BranchRepository extends BaseRepository<UUID,Branch> {
    private static BranchRepository branchRepository = null;
    private final String PATH_OF_BRANCH = "src/main/java/branch/Branch.txt";
    @Override
    protected String getFilePath() {
        return PATH_OF_BRANCH;
    }

    public static BranchRepository getInstance() {
        if(branchRepository == null){
            return new BranchRepository();
        }
        return branchRepository;
    }

}
