// File generated from our OpenAPI spec
package com.stripe.model.identity;

import com.google.gson.annotations.SerializedName;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.ExpandableField;
import com.stripe.model.HasId;
import com.stripe.model.MetadataStore;
import com.stripe.model.StripeObject;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;
import com.stripe.param.identity.VerificationSessionCancelParams;
import com.stripe.param.identity.VerificationSessionCreateParams;
import com.stripe.param.identity.VerificationSessionListParams;
import com.stripe.param.identity.VerificationSessionRetrieveParams;
import com.stripe.param.identity.VerificationSessionUpdateParams;
import java.util.List;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class VerificationSession extends ApiResource
    implements HasId, MetadataStore<VerificationSession> {
  /**
   * This string value can be passed to stripe.js to embed a verification flow directly into your
   * app.
   */
  @SerializedName("client_secret")
  String clientSecret;

  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  @SerializedName("created")
  Long created;

  /** Always true for a deleted object. */
  @SerializedName("deleted")
  Boolean deleted;

  /** Unique identifier for the object. */
  @Getter(onMethod_ = {@Override})
  @SerializedName("id")
  String id;

  /** Hash of details on the last error encountered in the verification process. */
  @SerializedName("last_error")
  LastError lastError;

  /** Link to the most recent completed VerificationReport for this Session. */
  @SerializedName("last_verification_report")
  @Getter(lombok.AccessLevel.NONE)
  @Setter(lombok.AccessLevel.NONE)
  ExpandableField<VerificationReport> lastVerificationReport;

  /**
   * Has the value {@code true} if the object exists in live mode or the value {@code false} if the
   * object exists in test mode.
   */
  @SerializedName("livemode")
  Boolean livemode;

  /**
   * Set of <a href="https://stripe.com/docs/api/metadata">key-value pairs</a> that you can attach
   * to an object. This can be useful for storing additional information about the object in a
   * structured format.
   */
  @Getter(onMethod_ = {@Override})
  @SerializedName("metadata")
  Map<String, String> metadata;

  /**
   * String representing the object's type. Objects of the same type share the same value.
   *
   * <p>Equal to {@code identity.verification_session}.
   */
  @SerializedName("object")
  String object;

  @SerializedName("options")
  Options options;

  /**
   * Status of this VerificationSession. Read more about each <a
   * href="https://stripe.com/docs/identity/how-sessions-work">VerificationSession status</a>.
   *
   * <p>One of {@code canceled}, {@code processing}, {@code requires_input}, or {@code verified}.
   */
  @SerializedName("status")
  String status;

  /**
   * Type of report requested.
   *
   * <p>One of {@code document}, or {@code id_number}.
   */
  @SerializedName("type")
  String type;

  /**
   * Link to the Stripe-hosted identity verification portal that you can send a user to for
   * verification.
   */
  @SerializedName("url")
  String url;

  /** Hash of verified data about this person that results from a successful verification report. */
  @SerializedName("verified_outputs")
  VerifiedOutputs verifiedOutputs;

  /** Get ID of expandable {@code lastVerificationReport} object. */
  public String getLastVerificationReport() {
    return (this.lastVerificationReport != null) ? this.lastVerificationReport.getId() : null;
  }

  public void setLastVerificationReport(String id) {
    this.lastVerificationReport = ApiResource.setExpandableFieldId(id, this.lastVerificationReport);
  }

  /** Get expanded {@code lastVerificationReport}. */
  public VerificationReport getLastVerificationReportObject() {
    return (this.lastVerificationReport != null) ? this.lastVerificationReport.getExpanded() : null;
  }

  public void setLastVerificationReportObject(VerificationReport expandableObject) {
    this.lastVerificationReport =
        new ExpandableField<VerificationReport>(expandableObject.getId(), expandableObject);
  }

  /** Create a new VerificationSession to begin the verification process. */
  public VerificationSession create(Map<String, Object> params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /** Create a new VerificationSession to begin the verification process. */
  public VerificationSession create(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/identity/verification_sessions");
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, VerificationSession.class, options);
  }

  /** Create a new VerificationSession to begin the verification process. */
  public VerificationSession create(VerificationSessionCreateParams params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /** Create a new VerificationSession to begin the verification process. */
  public VerificationSession create(VerificationSessionCreateParams params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/identity/verification_sessions");
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, VerificationSession.class, options);
  }

  /**
   * Retrieves an existing VerificationSession. When the session <code>status</code> is <code>
   * requires_input</code>, this method guarantees that the redirect <code>url</code> is fresh: if
   * your user has previously visited this session, a new <code>url</code> will be returned. Before
   * redirecting your user to Stripe, ensure that you have just Created or Retrieved the
   * VerificationSession; never cache or store the <code>url</code>.
   */
  public VerificationSession retrieve(String session) throws StripeException {
    return retrieve(session, (Map<String, Object>) null, (RequestOptions) null);
  }

  /**
   * Retrieves an existing VerificationSession. When the session <code>status</code> is <code>
   * requires_input</code>, this method guarantees that the redirect <code>url</code> is fresh: if
   * your user has previously visited this session, a new <code>url</code> will be returned. Before
   * redirecting your user to Stripe, ensure that you have just Created or Retrieved the
   * VerificationSession; never cache or store the <code>url</code>.
   */
  public VerificationSession retrieve(String session, RequestOptions options)
      throws StripeException {
    return retrieve(session, (Map<String, Object>) null, options);
  }

  /**
   * Retrieves an existing VerificationSession. When the session <code>status</code> is <code>
   * requires_input</code>, this method guarantees that the redirect <code>url</code> is fresh: if
   * your user has previously visited this session, a new <code>url</code> will be returned. Before
   * redirecting your user to Stripe, ensure that you have just Created or Retrieved the
   * VerificationSession; never cache or store the <code>url</code>.
   */
  public VerificationSession retrieve(
      String session, Map<String, Object> params, RequestOptions options) throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format(
                "/v1/identity/verification_sessions/%s", ApiResource.urlEncodeId(session)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, VerificationSession.class, options);
  }

  /**
   * Retrieves an existing VerificationSession. When the session <code>status</code> is <code>
   * requires_input</code>, this method guarantees that the redirect <code>url</code> is fresh: if
   * your user has previously visited this session, a new <code>url</code> will be returned. Before
   * redirecting your user to Stripe, ensure that you have just Created or Retrieved the
   * VerificationSession; never cache or store the <code>url</code>.
   */
  public VerificationSession retrieve(
      String session, VerificationSessionRetrieveParams params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format(
                "/v1/identity/verification_sessions/%s", ApiResource.urlEncodeId(session)));
    return ApiResource.request(
        ApiResource.RequestMethod.GET, url, params, VerificationSession.class, options);
  }

  /**
   * List all verification sessions. Can optionally provide a status to return only
   * VerificationSessions with that status. Can optionally specify a query filter on created
   * timestamp.
   */
  public VerificationSessionCollection list(Map<String, Object> params) throws StripeException {
    return list(params, (RequestOptions) null);
  }

  /**
   * List all verification sessions. Can optionally provide a status to return only
   * VerificationSessions with that status. Can optionally specify a query filter on created
   * timestamp.
   */
  public VerificationSessionCollection list(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/identity/verification_sessions");
    return ApiResource.requestCollection(url, params, VerificationSessionCollection.class, options);
  }

  /**
   * List all verification sessions. Can optionally provide a status to return only
   * VerificationSessions with that status. Can optionally specify a query filter on created
   * timestamp.
   */
  public VerificationSessionCollection list(VerificationSessionListParams params)
      throws StripeException {
    return list(params, (RequestOptions) null);
  }

  /**
   * List all verification sessions. Can optionally provide a status to return only
   * VerificationSessions with that status. Can optionally specify a query filter on created
   * timestamp.
   */
  public VerificationSessionCollection list(
      VerificationSessionListParams params, RequestOptions options) throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/identity/verification_sessions");
    return ApiResource.requestCollection(url, params, VerificationSessionCollection.class, options);
  }

  /**
   * Mark a VerificationSession as canceled.
   *
   * <p>If the VerificationSession is in the <code>processing</code> state, you must wait until it
   * finishes before cancelling it.
   */
  public VerificationSession cancel() throws StripeException {
    return cancel((Map<String, Object>) null, (RequestOptions) null);
  }

  /**
   * Mark a VerificationSession as canceled.
   *
   * <p>If the VerificationSession is in the <code>processing</code> state, you must wait until it
   * finishes before cancelling it.
   */
  public VerificationSession cancel(RequestOptions options) throws StripeException {
    return cancel((Map<String, Object>) null, options);
  }

  /**
   * Mark a VerificationSession as canceled.
   *
   * <p>If the VerificationSession is in the <code>processing</code> state, you must wait until it
   * finishes before cancelling it.
   */
  public VerificationSession cancel(Map<String, Object> params) throws StripeException {
    return cancel(params, (RequestOptions) null);
  }

  /**
   * Mark a VerificationSession as canceled.
   *
   * <p>If the VerificationSession is in the <code>processing</code> state, you must wait until it
   * finishes before cancelling it.
   */
  public VerificationSession cancel(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format(
                "/v1/identity/verification_sessions/%s/cancel",
                ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, VerificationSession.class, options);
  }

  /**
   * Mark a VerificationSession as canceled.
   *
   * <p>If the VerificationSession is in the <code>processing</code> state, you must wait until it
   * finishes before cancelling it.
   */
  public VerificationSession cancel(VerificationSessionCancelParams params) throws StripeException {
    return cancel(params, (RequestOptions) null);
  }

  /**
   * Mark a VerificationSession as canceled.
   *
   * <p>If the VerificationSession is in the <code>processing</code> state, you must wait until it
   * finishes before cancelling it.
   */
  public VerificationSession cancel(VerificationSessionCancelParams params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format(
                "/v1/identity/verification_sessions/%s/cancel",
                ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, VerificationSession.class, options);
  }

  /** Update properties on a VerificationSession. */
  @Override
  public VerificationSession update(Map<String, Object> params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /** Update properties on a VerificationSession. */
  @Override
  public VerificationSession update(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format(
                "/v1/identity/verification_sessions/%s", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, VerificationSession.class, options);
  }

  /** Update properties on a VerificationSession. */
  public VerificationSession update(VerificationSessionUpdateParams params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /** Update properties on a VerificationSession. */
  public VerificationSession update(VerificationSessionUpdateParams params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(),
            String.format(
                "/v1/identity/verification_sessions/%s", ApiResource.urlEncodeId(this.getId())));
    return ApiResource.request(
        ApiResource.RequestMethod.POST, url, params, VerificationSession.class, options);
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class LastError extends StripeObject {
    /**
     * A short machine-readable string giving the reason for the verification or user-session
     * failure.
     *
     * <p>One of {@code abandoned}, {@code consent_declined}, {@code country_not_supported}, {@code
     * device_not_supported}, {@code document_expired}, {@code document_manipulated}, {@code
     * document_type_not_supported}, {@code document_unverified_other}, {@code
     * id_number_insufficient_document_data}, {@code id_number_mismatch}, {@code
     * id_number_unverified_other}, {@code selfie_document_missing_photo}, {@code
     * selfie_face_mismatch}, {@code selfie_manipulated}, {@code selfie_unverified_other}, or {@code
     * under_supported_age}.
     */
    @SerializedName("code")
    String code;

    /**
     * A human-readable message giving the reason for the failure. These messages can be shown to
     * your users.
     */
    @SerializedName("reason")
    String reason;
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class Options extends StripeObject {
    @SerializedName("document")
    Document document;

    @SerializedName("id_number")
    IdNumber idNumber;

    @Getter
    @Setter
    @EqualsAndHashCode(callSuper = false)
    public static class Document extends StripeObject {
      /** Restrict the list of allowed document type to these types. */
      @SerializedName("allowed_types")
      List<String> allowedTypes;

      /** Require that the user provide an id number which will be verified. */
      @SerializedName("require_id_number")
      Boolean requireIdNumber;

      /** Require that the user capture documents live with their webcam or phone camera. */
      @SerializedName("require_live_capture")
      Boolean requireLiveCapture;

      /** Require that the user provide a selfie to compare against the document photo. */
      @SerializedName("require_matching_selfie")
      Boolean requireMatchingSelfie;
    }

    @Getter
    @Setter
    @EqualsAndHashCode(callSuper = false)
    public static class IdNumber extends StripeObject {}
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class VerifiedOutputs extends StripeObject {
    /** Verified address of the user. */
    @SerializedName("address")
    Address address;

    /** Verified date of birth of the user. */
    @SerializedName("dob")
    Date dob;

    /** Verified first name of the user. */
    @SerializedName("first_name")
    String firstName;

    /** Verified national id number of the user. */
    @SerializedName("id_number")
    String idNumber;

    /**
     * Country / type of verified national id number.
     *
     * <p>One of {@code br_cpf}, {@code sg_nric}, or {@code us_ssn}.
     */
    @SerializedName("id_number_type")
    String idNumberType;

    /** Verified last name of the user. */
    @SerializedName("last_name")
    String lastName;

    @Getter
    @Setter
    @EqualsAndHashCode(callSuper = false)
    public static class Address extends StripeObject {
      /** City, district, suburb, town, or village. */
      @SerializedName("city")
      String city;

      /**
       * Two-letter country code (<a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO
       * 3166-1 alpha-2</a>).
       */
      @SerializedName("country")
      String country;

      /** Address line 1 (e.g., street, PO Box, or company name). */
      @SerializedName("line1")
      String line1;

      /** Address line 2 (e.g., apartment, suite, unit, or building). */
      @SerializedName("line2")
      String line2;

      /** ZIP or postal code. */
      @SerializedName("postal_code")
      String postalCode;

      /** State, county, province, or region. */
      @SerializedName("state")
      String state;
    }

    @Getter
    @Setter
    @EqualsAndHashCode(callSuper = false)
    public static class Date extends StripeObject {
      /** Numerical day between 1 and 31. */
      @SerializedName("day")
      Long day;

      /** Numerical month between 1 and 12. */
      @SerializedName("month")
      Long month;

      /** The four-digit year. */
      @SerializedName("year")
      Long year;
    }
  }
}
