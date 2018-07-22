package com.icred.quikdata.Repository;

import android.support.annotation.NonNull;

import java.util.List;

import io.realm.Realm;

import static com.google.common.base.Preconditions.checkNotNull;

public class DNCAFormRepository implements DNCAFormDataSource {

    private static DNCAFormRepository INSTANCE = null;
    private final DNCAFormDataSource mDncaFormLocalDataSource;
//    private DNCAForm mDncaForm;

    private static Realm mRealm;
//    private Form mForm;

    /**
     * Private constructor
     */
    private DNCAFormRepository(@NonNull DNCAFormDataSource dncaFormLocalDataSource) {
        mDncaFormLocalDataSource = checkNotNull(dncaFormLocalDataSource);
    }

    /**
     * Returns the single instance of this class, creating it if necessary
     * @param dncaFormLocalDataSource
     * @return
     */
    public static DNCAFormRepository getInstance(@NonNull DNCAFormDataSource dncaFormLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new DNCAFormRepository(dncaFormLocalDataSource);
        }
        if (mRealm == null) {
            mRealm = Realm.getDefaultInstance();
        }
        return INSTANCE;
    }

    /**
     * Destroys instance to create it the next time newInstance() is called
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }

    /**
     * Loads all DNCA forms from source
     * @param callback
     */
    @Override
    public void loadAllDncaForms(@NonNull LoadDncaFormsCallback callback) {
//        GetAllDncaTask getAllDncaTask = new GetAllDncaTask(callback);
//        getAllDncaTask.execute(AppConstants.URL + AppConstants.ROUTE_DNCA);
    }

    /**
     * Creates a new and empty DNCA form
     * @param callback
     */
    @Override
    public void retrieveNewDncaForm(@NonNull GetDncaFormCallback callback) {
        checkNotNull(callback);

//        if (mDncaForm == null) {
//            mDncaForm = new DNCAForm();
//        }
//        callback.onDncaFormLoaded(mDncaForm);
    }

    /**
     * Submits the new DNCA form int is current state
     * @param callback
     */
    @Override
    public void submitDncaForm(@NonNull SubmitDncaFormCallback callback) {
        checkNotNull(callback);

        // Normalize DNCA form data first
//        mDncaForm.normalize();

        // Serialize to JSON
//        Gson formJson = new Gson();
//        final String jsonData = formJson.toJson(mDncaForm);
//
//        mRealm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                Form form = realm.createObject(Form.class, UUID.randomUUID().toString());
//                form.setData(jsonData);
//                realm.insertOrUpdate(form);
//            }
//        });

        // Submit DNCA form
        // TODO: If there is internet, submit the form immediately
//        SubmitNewDncaTask task = new SubmitNewDncaTask(mDncaForm, callback);
//        task.execute(AppConstants.URL + AppConstants.ROUTE_DNCA);
    }

    /**
     * Uploads DNCA form images
     * @param callback
     */
    @Override
    public void uploadImages(@NonNull UploadImagesCallback callback) {
        checkNotNull(callback);

        // Submit images first
//        UploadImagesTask task = new UploadImagesTask(mDncaForm.getCaseStories().getImages(), callback);
//        task.execute(AppConstants.URL + AppConstants.ROUTE_IMAGES);
    }

    /**
     * Updates DNCA form images with web URL
     * @param images
     */
    public void uploadDncaImageUrls(List<String> images) {
//        List<String> oldImagesUrl = mDncaForm.getCaseStories().getImages();
//        oldImagesUrl.clear();
//        oldImagesUrl.addAll(images);
    }

    /** NEW METHODS ================================================= */
    /**
    public void getAllForms(final IFormListDataManager callback) {
        mRealm.beginTransaction();
        callback.onFormListDataRetrieved(mRealm.where(Form.class).findAll());
        mRealm.commitTransaction();
    }

    public void getPrefilledData(final IBaseDataManager<PrefilledData> callback) {

        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                PrefilledData prefilledData = realm.where(PrefilledData.class).findFirst();
                if (prefilledData == null)
                {
                    prefilledData = realm.createObject(PrefilledData.class);

                    {
                        BaselinePopulation baselinePopulation = realm.createObject(BaselinePopulation.class, AppUtil.generateId());
                        RealmList<BaselinePopulationRow> rows = new RealmList<>();
                        for (GenericEnumDataRow.AgeGroup ageGroup : GenericEnumDataRow.AgeGroup.values()) {
                            if (ageGroup == GenericEnumDataRow.AgeGroup.ALL) continue;

                            BaselinePopulationRow row = realm.createObject(BaselinePopulationRow.class, AppUtil.generateId());
                            row.setAgeGroup(ageGroup.toString());
                            row.setMale(13);
                            row.setFemale(25);
                            rows.add(row);
                        }
                        baselinePopulation.setRows(rows);
                        prefilledData.setBaselinePopulation(baselinePopulation);
                    }

                    {
                        BaselineFamilies baselineFamilies = realm.createObject(BaselineFamilies.class, AppUtil.generateId());
                        baselineFamilies.setFamilies(11);
                        baselineFamilies.setHouseholds(22);
                        prefilledData.setBaselineFamilies(baselineFamilies);
                    }

                    {
                        BaselineHouses baselineHouses = realm.createObject(BaselineHouses.class, AppUtil.generateId());
                        RealmList<BaselineHousesRow> rows = new RealmList<>();
                        for (GenericEnumDataRow.HouseType houseType : GenericEnumDataRow.HouseType.values()) {
                            if (houseType == GenericEnumDataRow.HouseType.ALL) continue;

                            BaselineHousesRow row = realm.createObject(BaselineHousesRow.class, AppUtil.generateId());
                            row.setHouseType(houseType.toString());
                            row.setNumber(33);
                            rows.add(row);
                        }
                        baselineHouses.setRows(rows);
                        prefilledData.setBaselineHouses(baselineHouses);
                    }
                }

                if(callback != null) {
                    callback.onDataReceived(prefilledData);
                }
            }
        });
    }

    public void getForm(final IBaseDataManager<Form> callback) {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Form form = realm.createObject(Form.class, AppUtil.generateId());
                FormDetails formDetails = realm.createObject(FormDetails.class, AppUtil.generateId());
                form.setFormDetails(formDetails);

                GeneralInformation generalInformation = realm.createObject(GeneralInformation.class, AppUtil.generateId());
                CalamityDetails calamityDetails = realm.createObject(CalamityDetails.class, AppUtil.generateId());
                generalInformation.setCalamityDetails(calamityDetails);

                PopulationData populationData = realm.createObject(PopulationData.class, AppUtil.generateId());
                generalInformation.setPopulationData(populationData);

                FamilyDetails familyDetails = realm.createObject(FamilyDetails.class, AppUtil.generateId());
                generalInformation.setFamilyDetails(familyDetails);

                VulnerableData vulnerableData = realm.createObject(VulnerableData.class, AppUtil.generateId());
                generalInformation.setVulnerableData(vulnerableData);

                CasualtiesData casualtiesData = realm.createObject(CasualtiesData.class, AppUtil.generateId());
                generalInformation.setCasualtiesData(casualtiesData);

                DeathCauseData deathCauseData = realm.createObject(DeathCauseData.class, AppUtil.generateId());
                generalInformation.setDeathCauseData(deathCauseData);

                InfrastructureData infrastructureData = realm.createObject(InfrastructureData.class, AppUtil.generateId());
                generalInformation.setInfrastructureData(infrastructureData);

                form.setGeneralInformation(generalInformation);
                mForm = realm.copyFromRealm(form);
                callback.onDataReceived(mForm);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
            }
        });
    }

    public void getFormDetails(final IBaseDataManager<FormDetails> callback) {
        callback.onDataReceived(mForm.getFormDetails());
    }

    public void getGeneralInformation(final IBaseDataManager<GeneralInformation> callback) {
        callback.onDataReceived(mForm.getGeneralInformation());
    }

    public void insertToDb(RealmObject object) {
        mRealm.beginTransaction();
        mRealm.insert(object);
        mRealm.commitTransaction();
    }
    */

    public Realm getRealm() {
        return mRealm;
    }
}
