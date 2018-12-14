package com.qa.cvapi.constants;

public class Constants {

	// CV Endpoints
	public static final String CV_PATH_EP = "/cv";
	public static final String CV_GET_ALL_EP = "/getAll";
	public static final String CV_GET_CV_EP = "/getCV/{id}";
	public static final String CV_GET_CVS_EP = "/getCVs";
	public static final String CV_DELETE_EP = "/deleteCV/{id}";
	public static final String CV_UPDATE_EP = "/updateCV/{id}";

	// Flag Endpoints
	public static final String CV_ALL_FLAGGED_EP = "/getAllFlagged";
	public static final String CV_MEDIUM_FLAGGED_EP = "/getAllMediumFlagged";
	public static final String CV_BAD_FLAGGED_EP = "/getAllBadFlagged";
	public static final String CV_UPDATE_FLAG = "/updateFlag/{id}/{flag}";

	// CV Upload Endpoints
	public static final String CV_ADD = "/cv/addcv";
	public static final String CV_REDIRECT = "redirect:/cv/addcv";
	public static final String CV_URL = "/files/{filename:.+}";

	// CV
	public static final String CV_SUCCESSFUL = "You successfully uploaded ";
	public static final String CV_DELETED = "CV has been deleted";
	public static final String CV_UPDATED = "CV has been updated";
	public static final String CV_FILES_PATH = "http://localhost:8081/files/";
	public static final String CV_FLAGGED = "This CV has been flagged (FYI... snitches get stitches)";
	public static final String CV__ALREADY_FLAGGED = "CV is already flagged";

	// Storage
	public static final String STORAGE_FAIL_EMPTY = "Failed to store empty file ";
	public static final String STORAGE_PATH_FAIL = "Cannot store file with relative path outside current directory ";
	public static final String STORAGE_FILE_FAIL = "Failed to store file ";
	public static final String STORAGE_FAIL_TO_READ = "Failed to read stored files";
	public static final String STORAGE_COULD_NOT_READ = "Could not read file: ";
	public static final String STORAGE_COULD_NOT_INITIALISE = "Could not initialize storage";

	// Storage Location
	public static final String STORAGE_PATH = "storage";
	public static final String STORAGE_DIR = "upload-dir";
	public static final String DEFAULT_FILE = "failed-upload.txt";

	// Test strings
	public static final String TEST_PATH = "Test Path";
}